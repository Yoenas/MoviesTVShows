package com.yoenas.movietvshow.di

import com.yoenas.movietvshow.network.ApiConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideNetworkClient(): ApiConfig {
        return ApiConfig
    }
}
