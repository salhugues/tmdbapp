package com.salhugues.tmdbandroid.app.domain.model

data class Tv(
    override var id: Int,
    override var mediaType: String = String(),
    val name: String,
    val popularity: Float,
    val profilePath: String,
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val posterPath: String,
    val firstAirDate: String,
    val voteAverage: Float,
    val voteCount: Int
) : Favorite()
