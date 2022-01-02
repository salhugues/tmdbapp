package com.salhugues.tmdbandroid.data

interface EntityMapper<E, D> {
    fun mapFromEntity(item: E): D
    fun mapToEntity(item: D): E
}
