package com.example.talentomobiletechtest.common.data.repository

import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemesRoot
import retrofit2.Call
import retrofit2.http.GET

interface MadridThemesRepository {

    @GET("/egob/catalogo/theme.json")
    fun getApiThemesRootCall(): Call<ApiThemesRoot>

}