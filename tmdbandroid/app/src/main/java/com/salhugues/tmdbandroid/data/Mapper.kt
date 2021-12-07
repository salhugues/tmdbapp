package com.salhugues.tmdbandroid.data

interface Mapper<A, B> {
    fun transform(item: A): B
    fun revert(item: B): A
}

interface DomainMapper<A, B, C, D> {
    fun asMovie(item: A): B
    fun asPerson(item: A): C
    fun asTv(item: A): D
}
