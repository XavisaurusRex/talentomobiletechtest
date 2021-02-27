package com.example.talentomobiletechtest.common.dependencyinjection.app

import cat.devsofthecoast.vectortechincaltest.feature.userlist.data.remote.impl.AvailableThemesRequestImpl
import com.example.talentomobiletechtest.common.data.repository.MadridThemesRepository
import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    @AppScope
    fun provideAvailableThemesRequest(madridThemesRepository: MadridThemesRepository): AvailableThemesRequest =
        AvailableThemesRequestImpl(madridThemesRepository)

    @Provides
    @AppScope
    fun providesMadridThemesRepository(@MadridThemesScope retrofit: Retrofit): MadridThemesRepository =
        retrofit.create(MadridThemesRepository::class.java)
}
