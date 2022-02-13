package com.yoenas.movietvshow.di

import com.yoenas.movietvshow.data.local.LocalDataSource
import com.yoenas.movietvshow.data.local.room.MovieTvDao
import com.yoenas.movietvshow.data.remote.RemoteDataSource
import com.yoenas.movietvshow.data.MovieTvShowRepository
import com.yoenas.movietvshow.network.ApiConfig
import com.yoenas.movietvshow.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiConfig: ApiConfig) = RemoteDataSource(apiConfig)

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: MovieTvDao) = LocalDataSource(dao)

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        appExecutors: AppExecutors
    ): MovieTvShowRepository =
        MovieTvShowRepository(remoteDataSource, localDataSource, appExecutors)

}