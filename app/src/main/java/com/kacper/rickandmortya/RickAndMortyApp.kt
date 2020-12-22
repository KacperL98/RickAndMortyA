package com.kacper.rickandmortya

import android.app.Application
import timber.log.Timber

class RickAndMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}