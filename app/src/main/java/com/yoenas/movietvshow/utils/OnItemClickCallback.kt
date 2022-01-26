package com.yoenas.movietvshow.utils

import com.yoenas.movietvshow.data.MovieTvShow

interface OnItemClickCallback {
    fun onItemClicked(data: MovieTvShow)
}