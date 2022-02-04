package com.yoenas.movietvshow.di

import com.yoenas.movietvshow.data.network.ApiService
import com.yoenas.movietvshow.data.repository.DetailRepository
import com.yoenas.movietvshow.data.repository.HomeRepository
import com.yoenas.movietvshow.data.repository.MyDataSource
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
    fun provideDataSource(githubInterface: ApiService) =
        MyDataSource(githubInterface)

    @Provides
    @Singleton
    fun provideHomeRepository(dataSource: MyDataSource): HomeRepository =
        HomeRepository(dataSource)

    @Provides
    @Singleton
    fun provideDetailRepository(dataSource: MyDataSource): DetailRepository =
        DetailRepository(dataSource)
}