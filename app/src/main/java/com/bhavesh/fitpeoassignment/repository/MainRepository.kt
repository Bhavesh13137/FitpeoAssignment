package com.bhavesh.fitpeoassignment.repository

import androidx.lifecycle.MutableLiveData
import com.bhavesh.fitpeoassignment.api_helper.ApiHelper
import com.bhavesh.fitpeoassignment.api_helper.NetworkResult
import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper : ApiHelper) {



    suspend fun getPhotoApi() : NetworkResult<List<ApiResponseItem>> {
        val result = apiHelper.getApi()
        return if(result.isSuccessful){
            val responseBody =  result.body()
            if(responseBody != null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else{
            NetworkResult.Error("Something went wrong")
        }
    }
}