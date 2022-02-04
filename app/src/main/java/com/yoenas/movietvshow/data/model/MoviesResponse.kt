package com.yoenas.movietvshow.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesItem(
	@field:SerializedName("id")
	val id: Int? = 0,

	@field:SerializedName("title")
	val title: String? = "",

	@field:SerializedName("release_date")
	val releaseDate: String? = "",

	@field:SerializedName("genres")
	val genres: List<GenresItem>,

	@field:SerializedName("runtime")
	val runtime: Int? = 0,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = 0.0,

	@field:SerializedName("overview")
	val overview: String? = "",

	@field:SerializedName("poster_path")
	val posterPath: String? = "",

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = ""
) : Parcelable

@Parcelize
data class GenresItem(
	@field:SerializedName("name")
	val name: String? = ""
) : Parcelable