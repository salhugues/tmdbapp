package com.salhugues.tmdbandroid.domain.usecase

import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.domain.model.Movie
import kotlinx.coroutines.Deferred

interface HomeUseCase {
    suspend fun requestNowPlayingMovies(): Deferred<DataState<List<Movie>>>
}
