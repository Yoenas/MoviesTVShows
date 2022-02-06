package com.yoenas.movietvshow.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTvShow(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val genres: List<GenresItem>?,
    val runtime: Int? = null,
    val voteAverage: Double,
    val overview: String,
    val posterPath: String,
    val backdropPath: String? = null
) : Parcelable