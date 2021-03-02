package com.example.talentomobiletechtest.feature.centersfeed.data.mapper

import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiOrganization
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Organization
import retrofit2.Converter

interface OrganizationConverter : Converter<ApiOrganization, Organization> {
    override fun convert(value: ApiOrganization): Organization
}