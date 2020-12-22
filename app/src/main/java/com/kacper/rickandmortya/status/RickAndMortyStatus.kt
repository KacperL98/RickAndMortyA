package com.kacper.rickandmortya.status

import com.kacper.rickandmortya.R

object RickAndMortyStatus {
    fun getStatusColor(status: String): Int {
        return when (status) {
            "unknown" -> R.color.color1
            "Dead" -> R.color.color2
            "Alive" -> R.color.color3
            else -> R.color.Black
        }
    }
}