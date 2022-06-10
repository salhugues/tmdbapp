package com.salhugues.tmdbandroid.app.domain.interactor

import com.salhugues.tmdbandroid.app.common.DataState
import com.salhugues.tmdbandroid.app.data.repository.MovieRepository
import com.salhugues.tmdbandroid.app.domain.model.Movie
import com.salhugues.tmdbandroid.app.domain.usecase.HomeUseCase
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val movieRepository: MovieRepository
) : HomeUseCase {

    private var lastDataState: DataState<List<Movie>> = DataState.None

    override suspend fun requestNowPlayingMovies(): DataState<List<Movie>> {
        return when (lastDataState) {
            is DataState.Success, is DataState.Error -> DataState.None
            else -> {
                lastDataState = movieRepository.fetchNowPlayingMoviesAsync().await()
                lastDataState
            }
        }
    }
}
