package com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.LocationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiLocation
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Location

class LocationConverterImpl: LocationConverter {
    override fun convert(value: ApiLocation): Location =
        Location(
            value.latitude,
            value.longitude
        )
}