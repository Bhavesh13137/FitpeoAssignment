package com.bhavesh.fitpeoassignment.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhavesh.fitpeoassignment.databinding.ActivityMainDetailBinding
import com.bhavesh.fitpeoassignment.model.ApiResponseItem

class MainDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBackButton()

        val bundle = intent?.extras
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            binding.itemPhotoModel = bundle?.getParcelable<ApiResponseItem>("model", ApiResponseItem::class.java)
        }else{
            binding.itemPhotoModel = bundle?.getParcelable<ApiResponseItem>("model")
        }
    }

    private fun setBackButton(){
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Photo Detail"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}