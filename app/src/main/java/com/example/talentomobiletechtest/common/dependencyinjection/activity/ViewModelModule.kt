package com.example.talentomobiletechtest.common.dependencyinjection.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.common.dependencyinjection.activity.scopes.ViewModelKey
import com.example.talentomobiletechtest.common.view.viewmodel.TMTTViewModelFactory
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel.CentersFeedViewModel
import com.example.talentomobiletechtest.feature.details.domain.usecase.RequestCenterDetailsUseCase
import com.example.talentomobiletechtest.feature.details.view.viewmodel.CenterDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(
        creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory =
        TMTTViewModelFactory(creators)

    @Provides
    @IntoMap
    @ViewModelKey(CentersFeedViewModel::class)
    fun provideCentersFeedViewModel(requestFeedCentersUseCase: RequestFeedCentersUseCase): ViewModel =
        CentersFeedViewModel(requestFeedCentersUseCase)

    @Provides
    @IntoMap
    @ViewModelKey(CenterDetailsViewModel::class)
    fun provideCenterDetailsViewModel(requestCenterDetailsUseCase: RequestCenterDetailsUseCase): ViewModel =
        CenterDetailsViewModel(requestCenterDetailsUseCase)

}