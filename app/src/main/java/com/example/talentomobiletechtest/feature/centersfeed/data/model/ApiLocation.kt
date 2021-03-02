package com.example.talentomobiletechtest.feature.centersfeed.data.model

import com.google.gson.annotations.SerializedName

data class ApiLocation(
    @SerializedName("latitude") val latitude: Float,
    @SerializedName("longitude") val longitude: Float
)
