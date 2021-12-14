package com.salhugues.tmdbandroid.di

import com.salhugues.tmdbandroid.data.api.datasource.MovieApiDatasource
import com.salhugues.tmdbandroid.data.api.service.MovieApiService
import com.salhugues.tmdbandroid.data.repository.MovieRepository
import com.salhugues.tmdbandroid.data.repository.MovieRepositoryImpl
import com.salhugues.tmdbandroid.domain.interactor.HomeInteractor
import com.salhugues.tmdbandroid.domain.usecase.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun provideHomeUseCase(movieRepository: MovieRepository) = HomeInteractor(movieRepository) as HomeUseCase

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieApiDatasource: MovieApiDatasource,
        dispatcher: CoroutineDispatcher
    ) = MovieRepositoryImpl(movieApiDatasource, dispatcher) as MovieRepository

    @Singleton
    @Provides
    fun provideApiDatasource(movieApiService: MovieApiService) = MovieApiDatasource(movieApiService)
}
