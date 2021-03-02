package com.example.talentomobiletechtest.feature.centersfeed.data.mapper

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import retrofit2.Converter

interface CenterListConverter : Converter<ApiCentersRoot, List<Center>> {
    override fun convert(value: ApiCentersRoot): List<Center>
}
