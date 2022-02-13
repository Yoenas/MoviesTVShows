package com.yoenas.movietvshow.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoenas.movietvshow.data.model.MovieTvShow

@Database(entities = [MovieTvShow::class], version = 1, exportSchema = false)
abstract class MovieTvDB : RoomDatabase() {
    abstract fun movieTvDao(): MovieTvDao
}