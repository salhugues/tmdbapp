package com.salhugues.tmdbandroid.domain.interactor

import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.data.repository.MovieRepository
import com.salhugues.tmdbandroid.domain.model.Movie
import com.salhugues.tmdbandroid.domain.usecase.HomeUseCase
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
