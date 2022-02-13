package com.yoenas.movietvshow.presentation.favorite

import com.yoenas.movietvshow.data.model.MovieTvShow

interface FavoriteItemClickCallback {
    fun onItemClicked(data: MovieTvShow)
}