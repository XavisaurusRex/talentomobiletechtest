package com.example.talentomobiletechtest.feature.centersfeed.data.model

import com.google.gson.annotations.SerializedName

data class ApiThemesResult(
    @SerializedName("items") val items: List<ApiThemes>,
    @SerializedName("type") val type: List<String>
)
