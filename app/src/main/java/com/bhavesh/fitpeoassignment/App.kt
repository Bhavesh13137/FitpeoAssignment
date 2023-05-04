package com.bhavesh.fitpeoassignment

import android.app.Application
import com.bhavesh.fitpeoassignment.di.AppComponent
import com.bhavesh.fitpeoassignment.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }


}