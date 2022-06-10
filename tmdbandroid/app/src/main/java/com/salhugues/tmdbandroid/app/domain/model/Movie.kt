package com.salhugues.tmdbandroid.app.domain.model

data class Movie(
    override var id: Int,
    override var mediaType: String = String(),
    val popularity: Float,
    val backdropPath: String,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Float,
    val voteCount: Int
) : Favorite()
