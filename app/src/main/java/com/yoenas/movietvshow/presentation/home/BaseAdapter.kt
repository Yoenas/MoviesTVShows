package com.yoenas.movietvshow.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoenas.movietvshow.databinding.RowItemMovieTvBinding

abstract class BaseAdapter<T : Any> : RecyclerView.Adapter<BaseAdapter.MyViewHolder>() {

    var items = mutableListOf<T>()
    var listener: ((view: View, item: T, position: Int) -> Unit)? = null

    class MyViewHolder(val binding: RowItemMovieTvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemMovieTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = items.size
}