package com.yoenas.movietvshow.di

import android.content.Context
import com.yoenas.movietvshow.ApplicationModule
import com.yoenas.movietvshow.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): ApplicationModule {
        return app as ApplicationModule
    }

    @Provides
    fun provideAppExecutors() = AppExecutors()
}