package com.salhugues.tmdbandroid.domain

interface MultiMapper<S, M, P, T> {
    fun toMovie(item: S): M
    fun toPerson(item: S): P
    fun toTv(item: S): T
}
