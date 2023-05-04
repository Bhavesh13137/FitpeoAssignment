package com.bhavesh.fitpeoassignment.di

import com.bhavesh.fitpeoassignment.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitHelper::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}