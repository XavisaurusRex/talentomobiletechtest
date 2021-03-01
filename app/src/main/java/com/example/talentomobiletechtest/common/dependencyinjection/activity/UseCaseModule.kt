package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import com.example.talentomobiletechtest.feature.themes.domain.usecase.FirstWorkObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.SecondWorkObservableUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAvailableThemesUseCase(availableThemesRequest: AvailableThemesRequest) =
        GetAvailableThemesObservableUseCase(availableThemesRequest)

    @Provides
    fun provideFirstWorkObservableUseCase() = FirstWorkObservableUseCase()

    @Provides
    fun provideSecondWorkObservableUseCase() = SecondWorkObservableUseCase()
}