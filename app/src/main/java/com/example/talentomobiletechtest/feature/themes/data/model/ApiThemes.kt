package com.example.talentomobiletechtest.feature.themes.data.model

import com.google.gson.annotations.SerializedName

data class ApiThemes(
    @SerializedName("_about") val _about: String,
    @SerializedName("notation") val notation: String,
    @SerializedName("prefLabel") val prefLabel: List<String>
)
