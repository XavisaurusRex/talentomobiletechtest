package com.example.talentomobiletechtest.feature.themes.data.remote

import com.example.talentomobiletechtest.common.domain.ResponseWrapper
import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemesRoot

interface AvailableThemesRequest {
    suspend fun getAvailableThemes(): ResponseWrapper<ApiThemesRoot>
}