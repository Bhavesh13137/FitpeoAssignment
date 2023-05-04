package com.bhavesh.fitpeoassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bhavesh.fitpeoassignment.App
import com.bhavesh.fitpeoassignment.adapter.MainAdapter
import com.bhavesh.fitpeoassignment.databinding.ActivityMainBinding
import com.bhavesh.fitpeoassignment.model.ApiResponseItem
import com.bhavesh.fitpeoassignment.viewmodel.MainViewModel
import com.bhavesh.fitpeoassignment.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() , MainAdapter.OnClickListener{
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private val adapters = MainAdapter(this)
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        init()
    }

    private fun initViewModel() {
        (application as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]
    }

    private fun init(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = adapters
        }
        viewModel.photo.observe(this) {
            println("IT -> $it")
            adapters.setList(it.toMutableList())
        }
    }

    override fun onViewDetails(i: Int, model: ApiResponseItem) {
        val intent = Intent(this,MainDetailActivity::class.java)
        val bundle = bundleOf()
        bundle.putParcelable("model",model)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}