package com.example.talentomobiletechtest.common.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.themes.view.viewmodel.AvailableThemesViewModel

class VTTViewModelFactory(
    private val requestFeedCentersUseCase: RequestFeedCentersUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AvailableThemesViewModel::class.java)) {
            return AvailableThemesViewModel(
                requestFeedCentersUseCase
            ) as T
        }

        throw IllegalArgumentException("ViewModel Not Found")
    }
}