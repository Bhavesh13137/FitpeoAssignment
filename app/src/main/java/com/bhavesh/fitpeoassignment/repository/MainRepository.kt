package com.bhavesh.fitpeoassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bhavesh.fitpeoassignment.api_helper.ApiHelper
import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper : ApiHelper) {

    private val _photo = MutableLiveData<List<ApiResponseItem>>()

    val photo : LiveData<List<ApiResponseItem>>
        get() = _photo

    suspend fun getPhotoApi() {
        val result = apiHelper.getApi()
        if(result.isSuccessful && result.body() != null){
            _photo.postValue(result.body()!!)
        }
    }
}