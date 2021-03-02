package com.example.talentomobiletechtest.feature.details.data.mapper.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.AddressConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.LocationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.OrganizationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.details.data.mapper.CenterDetailsConverter

class CenterDetailsConverterImpl(
    private val addressConverter: AddressConverter,
    private val locationConverter: LocationConverter,
    private val organizationConverter: OrganizationConverter
) : CenterDetailsConverter {
    override fun convert(value: ApiCentersRoot): Center {
        val apiCenterDetails = value.values[0]
        return Center(
            apiCenterDetails.refId,
            apiCenterDetails.type,
            apiCenterDetails.id,
            apiCenterDetails.title,
            apiCenterDetails.relation,
            addressConverter.convert(apiCenterDetails.address),
            locationConverter.convert(apiCenterDetails.location),
            organizationConverter.convert(apiCenterDetails.organization)
        )
    }
}