package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAvailableThemesUseCase(availableThemesRequest: AvailableThemesRequest) =
        GetAvailableThemesUseCase(availableThemesRequest)

}