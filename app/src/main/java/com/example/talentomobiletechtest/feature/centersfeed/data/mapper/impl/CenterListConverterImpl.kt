package com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.AddressConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.CenterListConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.LocationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.OrganizationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiCentersRoot
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

class CenterListConverterImpl(
    private val addressConverter: AddressConverter,
    private val locationConverter: LocationConverter,
    private val organizationConverter: OrganizationConverter
) : CenterListConverter {

    override fun convert(value: ApiCentersRoot): List<Center> {
        val centers: ArrayList<Center> = arrayListOf()
        value.values.forEach {
            centers.add(
                Center(
                    it.refId,
                    it.type,
                    it.id,
                    it.title,
                    it.relation,
                    addressConverter.convert(it.address),
                    locationConverter.convert(it.location),
                    organizationConverter.convert(it.organization)
                )
            )
        }
        return centers
    }

}