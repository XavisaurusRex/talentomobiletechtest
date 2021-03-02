package com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.AddressConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Adress
import com.example.talentomobiletechtest.feature.centersfeed.data.model.ApiAddress

class AddressConverterImpl : AddressConverter {

    override fun convert(value: ApiAddress): Adress =
        Adress(
            value.locality,
            value.postalCode,
            value.streetAddress
        )

}