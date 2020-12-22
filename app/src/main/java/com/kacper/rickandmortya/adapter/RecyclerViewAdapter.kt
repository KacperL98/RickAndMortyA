package com.kacper.rickandmortya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kacper.rickandmortya.R
import com.kacper.rickandmortya.diffUtilCallBack.DiffUtilCallBack
import com.kacper.rickandmortya.network.CharacterData
import com.kacper.rickandmortya.status.RickAndMortyStatus
import kotlinx.android.synthetic.main.item_character.view.*

class RecyclerViewAdapter(private val listener: CharactersInterface) :
    PagedListAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder>(
        DiffUtilCallBack()
    ) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!, listener)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: CharacterData, listener: CharactersInterface) {
            with(itemView) {
                txtName.text = data.name
                txtSpecies.text = data.species
                txtStatus.text = data.status
                txtGender.text = data.gender

                val url = data.image
                Glide.with(context)
                    .load(url)
                    .into(imageThumb)
                viewStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        RickAndMortyStatus.getStatusColor(data.status)
                    )
                )

                setOnClickListener {
                    listener.openSingleCharacter(data.id)// the same -> itemView.context.startActivity(SingleCharacterActivity.prepareIntent(itemView.context,data.id))
                }

            }
        }
    }

    interface CharactersInterface {
        fun openSingleCharacter(id: Int)
    }
}