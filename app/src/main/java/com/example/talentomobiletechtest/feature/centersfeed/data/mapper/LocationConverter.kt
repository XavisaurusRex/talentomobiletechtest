package com.example.talentomobiletechtest.feature.centersfeed.data.mapper

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiLocation
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Location
import retrofit2.Converter

interface LocationConverter : Converter<ApiLocation, Location> {
    override fun convert(value: ApiLocation): Location
}