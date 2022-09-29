package com.example.weatherapppractise

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp: Application() {

    companion object {
        lateinit var INSTANCE: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}