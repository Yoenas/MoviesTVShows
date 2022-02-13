package com.yoenas.movietvshow.presentation.home

import com.yoenas.movietvshow.data.model.MovieTvShow

interface HomeItemClickCallback {
    fun onItemClicked(data: MovieTvShow)
}