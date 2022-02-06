package com.yoenas.movietvshow.presentation.home.tv

import com.bumptech.glide.Glide
import com.yoenas.movietvshow.BuildConfig
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.presentation.home.BaseAdapter

class TvAdapter : BaseAdapter<MovieTvShow>() {

    fun setData(data: List<MovieTvShow>?) {
        if (data == null) return
        items.clear()
        items.addAll(data)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = items[position]
        holder.binding.apply {
            tvTitle.text = data.title
            tvRatingScore.text = data.voteAverage.toString()
            Glide.with(imgPoster.context).load(BuildConfig.IMAGE_BASE_URL + data.posterPath)
                .placeholder(R.drawable.ic_movies).error(R.drawable.ic_movies)
                .into(imgPoster)
        }
        holder.itemView.setOnClickListener { listener?.invoke(it, data, position) }
    }
}