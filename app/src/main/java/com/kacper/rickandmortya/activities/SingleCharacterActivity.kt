package com.kacper.rickandmortya.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kacper.rickandmortya.R
import com.kacper.rickandmortya.model.MainActivityViewModel
import com.kacper.rickandmortya.status.RickAndMortyStatus
import kotlinx.android.synthetic.main.activity_single_character.*

class SingleCharacterActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_character)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val characterId = intent?.extras?.getInt(ID_CHARACTER)
        characterId?.let { id ->
            viewModel.getSingleCharacter(id)
        }

        updateUI()
    }

    private fun updateUI() {
        viewModel.characterData.observe(this, Observer {
            if (it != null) {
                txtNameSingle.text = it.name
                txtLocationSingle.text = it.location.name
                txtSpeciesSingle.text = it.species
                txtOriginSingle.text = it.origin.name

                Glide.with(this).load(it.image).circleCrop().into(imageThumbSingle)
                imageThumbSingle.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        RickAndMortyStatus.getStatusColor(it.status)
                    )
                )
            }
        })
    }

    companion object {
        private const val ID_CHARACTER = "id_character"
        fun prepareIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, SingleCharacterActivity::class.java)
            intent.putExtra(ID_CHARACTER, id)
            return intent
        }
    }


}