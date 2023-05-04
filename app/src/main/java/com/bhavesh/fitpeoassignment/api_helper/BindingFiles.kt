package com.bhavesh.fitpeoassignment.api_helper

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("picassoImage")
fun picassoImage(imageView: ImageView, imageUrl: String){
    Picasso.with(imageView.context).load(imageUrl).into(imageView)
}