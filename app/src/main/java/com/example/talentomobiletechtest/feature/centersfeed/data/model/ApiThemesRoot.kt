package com.example.talentomobiletechtest.feature.centersfeed.data.model

import com.google.gson.annotations.SerializedName

data class ApiThemesRoot(
    @SerializedName("format") val format: String,
    @SerializedName("version") val version: String,
    @SerializedName("result") val result: ApiThemesResult
)
