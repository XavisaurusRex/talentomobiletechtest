package com.example.talentomobiletechtest.feature.details.data.mapper

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import retrofit2.Converter

interface CenterDetailsConverter: Converter<ApiCentersRoot, Center> {
    override fun convert(value: ApiCentersRoot): Center
}