package com.salhugues.tmdbandroid.app.data.api.util

import com.salhugues.tmdbandroid.app.data.api.model.ApiError

object ApiUtil {
    fun handleApiError(code: Int) = when (code) {
        404 -> ApiError.NOT_FOUND
        503 -> ApiError.SERVER_ERROR
        else -> ApiError.UNKNOWN
    }
}
