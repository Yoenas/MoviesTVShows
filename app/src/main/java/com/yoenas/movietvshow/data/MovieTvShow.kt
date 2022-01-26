package com.yoenas.movietvshow.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTvShow(
    val id: String,
    val title: String,
    val released: String,
    val genre: String,
    val duration: String,
    val rating: String,
    val desc: String,
    val poster: String
) : Parcelable
