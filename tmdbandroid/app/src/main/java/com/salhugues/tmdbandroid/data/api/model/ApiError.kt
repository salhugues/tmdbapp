package com.salhugues.tmdbandroid.data.api.model

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("status_message") val statusMessage: String,
    @SerializedName("success") val success: Boolean,
)
