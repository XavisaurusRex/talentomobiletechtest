package com.example.talentomobiletechtest.common.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.feature.themes.domain.usecase.FirstWorkObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.SecondWorkObservableUseCase
import com.example.talentomobiletechtest.feature.themes.view.viewmodel.AvailableThemesViewModel

class VTTViewModelFactory(
    private val getAvailableThemesUseCase: GetAvailableThemesObservableUseCase,
    private val firstWorkObservableUseCase: FirstWorkObservableUseCase,
    private val secondWorkObservableUseCase: SecondWorkObservableUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvailableThemesViewModel::class.java)) {
            return AvailableThemesViewModel(
                getAvailableThemesUseCase,
                firstWorkObservableUseCase,
                secondWorkObservableUseCase
            ) as T
        }

        throw IllegalArgumentException("ViewModel Not Found")
    }
}