package com.kacper.rickandmortya.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kacper.rickandmortya.network.CharacterData

class CharacterListDataSourceFactory() : DataSource.Factory<Int, CharacterData>() {

    private var mutableLiveData: MutableLiveData<CharacterListDataSource>? = null

    init {

        mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, CharacterData> {
        val listDataSource = CharacterListDataSource()
        mutableLiveData?.postValue(listDataSource)
        return listDataSource
    }
}