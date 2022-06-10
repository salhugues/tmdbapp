package com.salhugues.tmdbandroid.app.common

import com.salhugues.tmdbandroid.app.data.api.model.ApiError

sealed class DataState<out R> {

    object None : DataState<Nothing>()

    object Loading : DataState<Nothing>()

    data class Success<out T>(val data: T) : DataState<T>()

    data class Error(
        val apiError: ApiError = ApiError.NOT_FOUND,
        val message: String? = null
    ) : DataState<Nothing>()
}
