package com.example.talentomobiletechtest.feature.themes.data.remote

import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemesRoot

interface AvailableThemesRequest {
    fun getAvailableThemes(): ApiThemesRoot
}