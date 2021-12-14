package com.salhugues.tmdbandroid.domain.interactor

import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.data.repository.MovieRepository
import com.salhugues.tmdbandroid.domain.model.Movie
import com.salhugues.tmdbandroid.domain.usecase.MovieUseCase
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    movieRepository: MovieRepository
) : MovieUseCase {

    override suspend fun getNowPlayingMovies(): Deferred<DataStateWrapper<List<Movie>>> {
        return getNowPlayingMovies()
    }
}
