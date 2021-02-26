package com.badzohugues.tmdbandroid.data.mapper

interface Mapper<A, B> {
    fun transform(item: A) : B
}

interface DomainMapper<A, B, C, D> {
    fun asMovie(item: A) : B
    fun asPerson(item: A) : C
    fun asTv(item: A) : D
}