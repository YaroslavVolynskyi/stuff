package com.yarik.stuff

import android.app.Application
import android.content.Context

class StuffApplication : Application() {

    companion object {

        lateinit var instance: StuffApplication

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }

    val dataManager = DataManager()

    override fun onCreate() {
        super.onCreate()
    }
}