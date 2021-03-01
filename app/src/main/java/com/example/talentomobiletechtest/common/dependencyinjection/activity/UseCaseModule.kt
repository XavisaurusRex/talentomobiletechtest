package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.impl.RequestCentersForHomelessPeopleUseCaseImpl
import com.example.talentomobiletechtest.feature.themes.domain.usecase.impl.RequestFeedCentersUseCaseImpl
import com.example.talentomobiletechtest.feature.themes.domain.usecase.impl.RequestJuvenileAndFamilyCareCentersUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAvailableThemesUseCase(
        requestCentersForHomelessPeopleUseCase: RequestCentersForHomelessPeopleUseCase,
        requestJuvenileAndFamilyCareCentersUseCase: RequestJuvenileAndFamilyCareCentersUseCase
    ): RequestFeedCentersUseCase =
        RequestFeedCentersUseCaseImpl(
            requestCentersForHomelessPeopleUseCase,
            requestJuvenileAndFamilyCareCentersUseCase
        )

    @Provides
    fun provideSecondWorkObservableUseCase(centersRepository: CentersRepository): RequestCentersForHomelessPeopleUseCase =
        RequestCentersForHomelessPeopleUseCaseImpl(centersRepository)

    @Provides
    fun provideFirstWorkObservableUseCase(centersRepository: CentersRepository): RequestJuvenileAndFamilyCareCentersUseCase =
        RequestJuvenileAndFamilyCareCentersUseCaseImpl(centersRepository)
}