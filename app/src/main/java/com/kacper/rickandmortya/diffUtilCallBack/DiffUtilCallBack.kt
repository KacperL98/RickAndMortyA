package com.kacper.rickandmortya.diffUtilCallBack

import androidx.recyclerview.widget.DiffUtil
import com.kacper.rickandmortya.network.CharacterData

class DiffUtilCallBack : DiffUtil.ItemCallback<CharacterData>() {

    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name && oldItem.species == newItem.species
    }
}