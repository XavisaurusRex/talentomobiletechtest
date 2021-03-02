package com.example.talentomobiletechtest.feature.details.data.remote

import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

interface CenterDetailsRepository {

    fun requestCenterDetails(url: String): Center

}