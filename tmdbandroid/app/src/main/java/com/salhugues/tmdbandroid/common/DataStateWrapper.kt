package com.salhugues.tmdbandroid.common

import java.lang.Exception

sealed class DataStateWrapper<out R> {

    object Idle : DataStateWrapper<Nothing>()
    object Loading : DataStateWrapper<Nothing>()
    data class Success<out T>(val data: T) : DataStateWrapper<T>()
    data class Error<out T>(
        val exception: Exception,
        val message: String?
    ) : DataStateWrapper<T>()
}
