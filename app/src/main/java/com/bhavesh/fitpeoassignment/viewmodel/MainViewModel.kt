package com.bhavesh.fitpeoassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.fitpeoassignment.api_helper.NetworkResult
import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import com.bhavesh.fitpeoassignment.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private val _photo = MutableLiveData<NetworkResult<List<ApiResponseItem>>>()
    val photo : LiveData<NetworkResult<List<ApiResponseItem>>>
        get() = _photo

    fun getPhoto(){
        viewModelScope.launch {
            val result = repository.getPhotoApi()
            _photo.postValue(result)
        }
    }
}