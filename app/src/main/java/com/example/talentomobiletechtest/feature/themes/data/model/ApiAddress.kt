package com.example.talentomobiletechtest.feature.themes.data.model

import com.google.gson.annotations.SerializedName

data class ApiAddress(
    @SerializedName("district") val district: ApiDistrict,
    @SerializedName("area") val area: ApiArea,
    @SerializedName("locality") val locality: String,
    @SerializedName("postal-code") val postalCode: String,
    @SerializedName("street-address") val streetAddress: String
)
