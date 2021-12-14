package com.salhugues.tmdbandroid.domain.model

open class Favorite {
    open var id: Int = 0
    open lateinit var mediaType: String
    open var isFavorite: Boolean = false
}
