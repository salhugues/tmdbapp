package com.salhugues.tmdbandroid.app.domain

interface DomainMapper<E, D> {
    fun mapToDomain(item: E): D
}
