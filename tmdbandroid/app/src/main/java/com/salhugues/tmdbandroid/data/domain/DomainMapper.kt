package com.salhugues.tmdbandroid.data.domain

interface DomainMapper<E, D> {
    fun mapToDomain(item: E): D
}
