package com.kacper.rickandmortya.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {

    @GET("character")
    fun getDataFromApi(@Query("page") page: Int): Call<RickAndMortyList>

    @GET("character/{id}")
    fun getSingleCharacter(@Path("id") id: Int): Call<CharacterData>//https://rickandmortyapi.com/api/character/2}
}