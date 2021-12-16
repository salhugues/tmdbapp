package com.salhugues.tmdbandroid.domain.usecase

import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.domain.model.Movie

interface HomeUseCase {
    suspend fun requestNowPlayingMovies(): DataState<List<Movie>>
}
