package com.example.talentomobiletechtest.common.data.repository

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface RetrofitCenterDetailsRepository {

    @GET
    fun getCenterDetails(@Url url: String?): Call<ApiCentersRoot>

}