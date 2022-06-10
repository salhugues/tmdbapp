package com.salhugues.tmdbandroid.app.domain.usecase

import com.salhugues.tmdbandroid.app.common.DataState
import com.salhugues.tmdbandroid.app.domain.model.Movie

interface HomeUseCase {
    suspend fun requestNowPlayingMovies(): DataState<List<Movie>>
}
