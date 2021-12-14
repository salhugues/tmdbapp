package com.salhugues.tmdbandroid.di

import com.salhugues.tmdbandroid.data.api.datasource.MovieApiDatasource
import com.salhugues.tmdbandroid.data.api.service.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideApiDatasource(movieApiService: MovieApiService) = MovieApiDatasource(movieApiService)
}
