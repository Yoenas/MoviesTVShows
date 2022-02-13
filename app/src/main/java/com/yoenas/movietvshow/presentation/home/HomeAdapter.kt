package com.yoenas.movietvshow.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoenas.movietvshow.BuildConfig
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.RowItemMovieTvBinding

class HomeAdapter(private val callback: HomeItemClickCallback) :
    PagedListAdapter<MovieTvShow, HomeAdapter.MyViewHolder>(DIFF_CALLBACK) {

    inner class MyViewHolder(val binding: RowItemMovieTvBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemMovieTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.binding.apply {
                tvTitle.text = data.title
                tvRatingScore.text = data.voteAverage.toString()
                Glide.with(imgPoster.context).load(BuildConfig.IMAGE_BASE_URL + data.posterPath)
                    .placeholder(R.drawable.ic_movies).error(R.drawable.ic_movies)
                    .into(imgPoster)
            }
            holder.itemView.setOnClickListener { callback.onItemClicked(data) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieTvShow>() {
            override fun areItemsTheSame(oldItem: MovieTvShow, newItem: MovieTvShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieTvShow, newItem: MovieTvShow): Boolean {
                return oldItem == newItem
            }
        }
    }
}