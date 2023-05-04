package com.bhavesh.fitpeoassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import com.bhavesh.fitpeoassignment.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val photo : LiveData<List<ApiResponseItem>>
    get() = repository.photo

    init{
        viewModelScope.launch {
            repository.getPhotoApi()
        }
    }
}