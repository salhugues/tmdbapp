package com.salhugues.tmdbandroid.data.domain

open class Favorite {
    open var id: Int = 0
    open lateinit var mediaType: String
    open var isFavorite: Boolean = false
}
