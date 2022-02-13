package com.yoenas.movietvshow.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yoenas.movietvshow.BuildConfig
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.RowItemFavoriteBinding

class FavoriteAdapter(private val callback: FavoriteItemClickCallback) :
    PagedListAdapter<MovieTvShow, FavoriteAdapter.MyViewHolder>(DIFF_CALLBACK) {

    inner class MyViewHolder(val binding: RowItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun getSwipeData(swipedPosition: Int): MovieTvShow? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        data?.let {
            holder.binding.apply {
                tvFavTitle.text = data.title
                tvDataDesc.text = data.overview
                Glide.with(imgFavPoster.context).load(BuildConfig.IMAGE_BASE_URL + data.posterPath)
                    .placeholder(R.drawable.ic_movies).error(R.drawable.ic_movies)
                    .into(imgFavPoster)
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