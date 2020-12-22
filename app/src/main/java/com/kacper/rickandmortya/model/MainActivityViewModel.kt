package com.kacper.rickandmortya.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kacper.rickandmortya.data.CharacterListDataSourceFactory
import com.kacper.rickandmortya.network.CharacterData
import com.kacper.rickandmortya.network.RetroInstance
import com.kacper.rickandmortya.network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class MainActivityViewModel : ViewModel() {

    private var charactersList: LiveData<PagedList<CharacterData>>? = null
    private var _characterData = MutableLiveData<CharacterData>()
    val characterData: LiveData<CharacterData> = _characterData

    init {
        paging()

    }

    private fun paging() {
        val factory = CharacterListDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        val executor = Executors.newFixedThreadPool(5)
        charactersList = LivePagedListBuilder<Int, CharacterData>(factory, config)
            .setFetchExecutor(executor)
            .build()
    }

    fun getSingleCharacter(id: Int) {
        val service = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = service.getSingleCharacter(id)
        call.enqueue(object : Callback<CharacterData> {
            override fun onResponse(call: Call<CharacterData>, response: Response<CharacterData>) {
                if (response.isSuccessful) {
                    _characterData.value = response.body()
                }
            }

            override fun onFailure(call: Call<CharacterData>, t: Throwable) {
            }
        })
    }

    fun getRecyclerListObserver(): LiveData<PagedList<CharacterData>>? {
        return charactersList
    }
}