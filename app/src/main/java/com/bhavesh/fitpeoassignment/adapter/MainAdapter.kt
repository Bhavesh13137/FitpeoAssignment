package com.bhavesh.fitpeoassignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhavesh.fitpeoassignment.BR
import com.bhavesh.fitpeoassignment.R
import com.bhavesh.fitpeoassignment.databinding.ItemPhotoBinding
import com.bhavesh.fitpeoassignment.model.ApiResponseItem

class MainAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var itemViewModels = mutableListOf<ApiResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list : List<ApiResponseItem>){
        this.itemViewModels.clear()
        this.itemViewModels.addAll(list)
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemPhotoModel: ApiResponseItem) {
            binding.setVariable(BR.itemPhotoModel, itemPhotoModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPhotoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_photo, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
        holder.itemView.setOnClickListener {
            onClickListener.onViewDetails(position,itemViewModels[position])
        }
    }

    override fun getItemCount(): Int {
        return itemViewModels.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnClickListener {
        fun onViewDetails(i: Int, model: ApiResponseItem)
    }
}