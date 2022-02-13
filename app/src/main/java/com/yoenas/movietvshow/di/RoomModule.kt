package com.yoenas.movietvshow.di

import androidx.room.Room
import com.yoenas.movietvshow.ApplicationModule
import com.yoenas.movietvshow.data.local.room.MovieTvDB
import com.yoenas.movietvshow.data.local.room.MovieTvDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: ApplicationModule): MovieTvDB {
        return Room.databaseBuilder(
            app,
            MovieTvDB::class.java,
            "movietv.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db: MovieTvDB) : MovieTvDao {
        return db.movieTvDao()
    }
}