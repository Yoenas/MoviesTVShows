package com.yoenas.movietvshow.di

import com.yoenas.movietvshow.data.remote.RemoteDataSource
import com.yoenas.movietvshow.data.repository.MovieTvShowRepository
import com.yoenas.movietvshow.network.ApiConfig
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
    fun provideDataSource(apiConfig: ApiConfig) = RemoteDataSource(apiConfig)

    @Provides
    @Singleton
    fun provideRepository(dataSource: RemoteDataSource): MovieTvShowRepository =
        MovieTvShowRepository(dataSource)

}