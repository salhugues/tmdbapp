package com.salhugues.tmdbandroid.app

import android.content.res.Resources
import com.salhugues.tmdbandroid.R
import com.salhugues.tmdbandroid.app.data.api.model.ApiError

fun errorMessage(error: ApiError, resources: Resources): String {
    return when (error) {
        ApiError.NOT_FOUND -> resources.getString(R.string.error_not_found)
        ApiError.SERVER_ERROR -> resources.getString(R.string.error_server)
        ApiError.UNKNOWN -> resources.getString(R.string.error_unknown)
    }
}
