package com.example.talentomobiletechtest.common.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.feature.themes.view.viewmodel.AvailableThemesViewModel
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesUseCase

class VTTViewModelFactory(
    private val getAvailableThemesUseCase: GetAvailableThemesUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvailableThemesViewModel::class.java)) {
            return AvailableThemesViewModel(
                getAvailableThemesUseCase
            ) as T
        }

        throw IllegalArgumentException("ViewModel Not Found")
    }
}