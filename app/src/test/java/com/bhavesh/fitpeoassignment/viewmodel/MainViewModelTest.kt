package com.bhavesh.fitpeoassignment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bhavesh.fitpeoassignment.api_helper.NetworkResult
import com.bhavesh.fitpeoassignment.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var mainRepository: MainRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getPhoto() = runTest {
        Mockito.`when`(mainRepository.getPhotoApi()).thenReturn(NetworkResult.Success(emptyList()))
        val sut = MainViewModel(mainRepository)
        sut.getPhoto()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = sut.photo.getOrAwaitValue()
        Assert.assertEquals(0,result.data!!.size)

    }
}