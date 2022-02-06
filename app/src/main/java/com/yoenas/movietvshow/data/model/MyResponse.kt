package com.yoenas.movietvshow.data.model

import com.google.gson.annotations.SerializedName

data class MyResponse<T>(
    @field:SerializedName("results")
    val results: List<T>,
)