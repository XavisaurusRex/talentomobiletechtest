package com.example.talentomobiletechtest.feature.themes.data.model

import com.google.gson.annotations.SerializedName

data class ApiCentersRoot(
    @SerializedName("@context") val context: ApiCentersRequestContext,
    @SerializedName("@graph") val values: List<ApiCenter>
)