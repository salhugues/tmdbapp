package com.salhugues.tmdbandroid.app.data.api.service

import com.salhugues.tmdbandroid.app.data.api.model.ApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/3/movie/now_playing")
    suspend fun nowPlaying(
        @Query("api_key") apiKey: String
    ): Response<ApiResult>
}
