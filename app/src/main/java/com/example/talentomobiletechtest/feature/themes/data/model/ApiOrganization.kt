package com.example.talentomobiletechtest.feature.themes.data.model

import com.google.gson.annotations.SerializedName

data class ApiOrganization(
    @SerializedName("organization-desc") val organizationDesc: String,
    @SerializedName("accesibility") val accesibility: String,
    @SerializedName("schedule") val schedule: String,
    @SerializedName("services") val services: String,
    @SerializedName("organization-name") val organizationName: String
)