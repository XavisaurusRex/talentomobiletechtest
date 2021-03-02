package com.example.talentomobiletechtest.feature.centersfeed.data.model

data class Center(
    val refId: String,
    val type: String,
    val id: String,
    val title: String,
    val relation: String,
    val address: Adress,
    val location: Location,
    val organization: Organization
)