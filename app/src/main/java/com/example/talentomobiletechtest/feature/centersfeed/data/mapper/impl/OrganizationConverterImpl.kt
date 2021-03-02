package com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.OrganizationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiOrganization
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Organization

class OrganizationConverterImpl : OrganizationConverter {
    override fun convert(value: ApiOrganization): Organization =
        Organization(
            value.organizationDesc,
            value.schedule,
            value.services,
            value.organizationName
        )
}