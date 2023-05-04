package com.bhavesh.fitpeoassignment.di

import com.bhavesh.fitpeoassignment.api_helper.ApiHelper
import com.bhavesh.fitpeoassignment.api_helper.HeaderInterceptor
import com.bhavesh.fitpeoassignment.constant.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitHelper {

    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL).client(makeOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun makeOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) : ApiHelper {
        return retrofit.create(ApiHelper::class.java)
    }

}