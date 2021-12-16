package com.salhugues.tmdbandroid.data.api.model

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("page") val page: Int?,
    @SerializedName("results") val results: List<ApiMulti>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)
