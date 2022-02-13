package com.yoenas.movietvshow.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowsItem(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("genres")
    val genres: List<GenresItem>,

    @field:SerializedName("episode_run_time")
    val episodeRunTime: List<Int?>,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String
) : Parcelable {
    constructor() : this(
        0,
        "",
        "",
        listOf(),
        listOf(),
        0.0,
        "",
        "",
        ""
    )
}
