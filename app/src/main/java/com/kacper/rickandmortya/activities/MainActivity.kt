package com.kacper.rickandmortya.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kacper.rickandmortya.R
import com.kacper.rickandmortya.adapter.RecyclerViewAdapter
import com.kacper.rickandmortya.model.MainActivityViewModel
import com.kacper.rickandmortya.network.CharacterData

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter =
                RecyclerViewAdapter(object : RecyclerViewAdapter.CharactersInterface {
                    override fun openSingleCharacter(id: Int) {
                        startActivity(SingleCharacterActivity.prepareIntent(this@MainActivity, id))
                    }

                })
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecyclerListObserver()?.observe(this, Observer<PagedList<CharacterData>> {
            if (it != null) {
                recyclerViewAdapter.submitList(it)
            } else {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_LONG).show()

            }
        })
    }

}