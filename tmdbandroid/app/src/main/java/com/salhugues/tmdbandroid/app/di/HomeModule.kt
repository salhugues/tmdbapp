package com.salhugues.tmdbandroid.app.di

import com.salhugues.tmdbandroid.app.data.api.datasource.MovieApiDatasource
import com.salhugues.tmdbandroid.app.data.api.service.MovieApiService
import com.salhugues.tmdbandroid.app.data.repository.MovieRepository
import com.salhugues.tmdbandroid.app.data.repository.MovieRepositoryImpl
import com.salhugues.tmdbandroid.app.domain.interactor.HomeInteractor
import com.salhugues.tmdbandroid.app.domain.usecase.HomeUseCase
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
