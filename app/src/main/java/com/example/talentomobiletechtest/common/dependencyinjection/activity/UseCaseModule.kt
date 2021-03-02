package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.feature.centersfeed.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.impl.RequestCentersForHomelessPeopleUseCaseImpl
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.impl.RequestFeedCentersUseCaseImpl
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.impl.RequestJuvenileAndFamilyCareCentersUseCaseImpl
import com.example.talentomobiletechtest.feature.details.data.remote.CenterDetailsRepository
import com.example.talentomobiletechtest.feature.details.domain.usecase.RequestCenterDetailsUseCase
import com.example.talentomobiletechtest.feature.details.domain.usecase.impl.RequestCenterDetailsUseCaseImpl
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

    @Provides
    fun provideRequestCenterDetailsUseCase(centerDetailsRepository: CenterDetailsRepository): RequestCenterDetailsUseCase =
        RequestCenterDetailsUseCaseImpl(centerDetailsRepository)
}