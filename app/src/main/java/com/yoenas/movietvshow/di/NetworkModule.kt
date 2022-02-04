package com.yoenas.movietvshow.di

import com.yoenas.movietvshow.data.network.ApiConfig
import com.yoenas.movietvshow.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideNetworkService(): ApiService {
        return ApiConfig.getApiService()
    }

}