package com.salhugues.tmdbandroid.domain.model

data class Person(
    override var id: Int,
    override var mediaType: String = String(),
    val gender: Int,
    val knownFor: List<Movie>,
    val knownForDepartment: String,
    val name: String,
    val popularity: Float,
    val profilePath: String,
    val adult: Boolean
) : Favorite()
