package com.kacper.rickandmortya.network

data class RickAndMortyList(val results: ArrayList<CharacterData>)

data class CharacterData(
    val id: Int,
    val name: String?,
    val species: String?,
    val image: String?,
    val status: String,
    val gender: String?,
    val origin: Origin,
    val location: Location
)
