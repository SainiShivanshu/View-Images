package com.example.assignment_chatwise_uk_limited.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_chatwise_uk_limited.databinding.ImageBinding
import com.example.assignment_chatwise_uk_limited.model.ImageModel

class ImageAdapter (val context: Context, val list:ArrayList<ImageModel>)
    : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context).load(list[position].url).into(holder.binding.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}