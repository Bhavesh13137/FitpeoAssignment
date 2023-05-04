package com.bhavesh.fitpeoassignment.api_helper



import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiHelper {

    @GET("photos")
    suspend fun getApi() : Response<List<ApiResponseItem>>

}