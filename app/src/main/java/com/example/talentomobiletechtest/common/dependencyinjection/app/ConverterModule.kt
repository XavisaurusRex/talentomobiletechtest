package com.example.talentomobiletechtest.common.dependencyinjection.app

import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.AddressConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.CenterListConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.LocationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.OrganizationConverter
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl.AddressConverterImpl
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl.CenterListConverterImpl
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl.LocationConverterImpl
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.impl.OrganizationConverterImpl
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ConverterModule {

    @Provides
    @MadridThemesScope
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @AppScope
    fun provideCenterListConverter(
        addressConverter: AddressConverter,
        locationConverter: LocationConverter,
        organizationConverter: OrganizationConverter
    ): CenterListConverter = CenterListConverterImpl(
        addressConverter,
        locationConverter,
        organizationConverter
    )

    @Provides
    fun provideAddressConverter(): AddressConverter =
        AddressConverterImpl()

    @Provides
    fun provideLocationConverter(): LocationConverter =
        LocationConverterImpl()

    @Provides
    fun provideOrganizationConverter(): OrganizationConverter =
        OrganizationConverterImpl()


}
