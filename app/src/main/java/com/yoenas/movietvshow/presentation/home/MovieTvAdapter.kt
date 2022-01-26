package com.yoenas.movietvshow.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.MovieTvShow
import com.yoenas.movietvshow.databinding.RowItemMovieTvBinding
import com.yoenas.movietvshow.utils.OnItemClickCallback

class MovieTvAdapter : RecyclerView.Adapter<MovieTvAdapter.MyViewHolder>() {

    private val listMovieTv = ArrayList<MovieTvShow>()
    private var onItemClicked: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClicked: OnItemClickCallback) {
        this.onItemClicked = onItemClicked
    }

    fun setData(data: List<MovieTvShow>?) {
        if (data == null) return
        listMovieTv.clear()
        listMovieTv.addAll(data)
    }

    class MyViewHolder(val binding: RowItemMovieTvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemMovieTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = listMovieTv[position].title
            tvRatingScore.text = listMovieTv[position].rating
            Glide.with(imgPoster.context).load(listMovieTv[position].poster)
                .placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image)
                .into(imgPoster)
        }
        holder.itemView.setOnClickListener { onItemClicked?.onItemClicked(listMovieTv[position]) }
    }

    override fun getItemCount() = listMovieTv.size
}