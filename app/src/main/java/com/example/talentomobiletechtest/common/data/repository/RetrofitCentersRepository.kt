package com.example.talentomobiletechtest.common.data.repository

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitCentersRepository {

    @GET("/egob/catalogo/205244-0-infancia-familia-adolescentes.json")
    fun getJuvenileAndFamilyCareCenters(): Call<ApiCentersRoot>

    @GET("egob/catalogo/205732-0-centros-sin-hogar.json")
    fun getCentersForHomelessPeople(): Call<ApiCentersRoot>

}