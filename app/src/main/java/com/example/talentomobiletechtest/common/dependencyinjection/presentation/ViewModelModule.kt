package com.example.talentomobiletechtest.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.example.talentomobiletechtest.common.view.viewmodel.TMTTViewModelFactory
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel.CentersFeedViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
class ViewModelModule {

    @Provides
    fun provideViewModelFactory(
        creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
        savedStateRegistryOwner: SavedStateRegistryOwner
    ): ViewModelProvider.Factory = TMTTViewModelFactory(creators, savedStateRegistryOwner)

    @Provides
    @IntoMap
    @ViewModelKey(CentersFeedViewModel::class)
    fun provideCentersFeedViewModel(requestFeedCentersUseCase: RequestFeedCentersUseCase): ViewModel =
        CentersFeedViewModel(requestFeedCentersUseCase)
}