package com.example.talentomobiletechtest.feature.centersfeed.data.mapper

import com.example.talentomobiletechtest.feature.centersfeed.data.model.Adress
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiAddress
import retrofit2.Converter

interface AddressConverter : Converter<ApiAddress, Adress> {
    override fun convert(value: ApiAddress): Adress
}