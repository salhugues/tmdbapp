package com.salhugues.tmdbandroid.domain

interface DomainMapper<E, D> {
    fun mapToDomain(item: E): D
}
