package com.example.talentomobiletechtest.feature.centersfeed.data.model

import com.google.gson.annotations.SerializedName

data class ApiCenterDetails(
  @SerializedName("@id") val refId: String,
  @SerializedName("@type") val type: String,
  @SerializedName("id") val id: String,
  @SerializedName("title") val title: String,
  @SerializedName("relation") val relation: String,
  @SerializedName("address") val address: ApiAddress,
  @SerializedName("location") val location: ApiLocation,
  @SerializedName("organization") val organization: ApiOrganization
)
