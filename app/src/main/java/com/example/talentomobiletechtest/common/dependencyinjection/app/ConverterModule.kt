package com.example.talentomobiletechtest.common.dependencyinjection.app

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
    fun provideThemesConverter(): CenterListConverter = CenterListConverter()


}
