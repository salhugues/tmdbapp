package com.salhugues.tmdbandroid.app.data

interface EntityMapper<E, D> {
    fun mapFromEntity(item: E): D
    fun mapToEntity(item: D): E
}
