package com.example.talentomobiletechtest.common.view.viewmodel

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Provider

class TMTTViewModelFactory(
    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        val provider = providersMap[modelClass]
        val viewModel = provider?.get() ?: throw RuntimeException("unsupported viewmodel type: $modelClass")
        if (viewModel is BaseViewModel) {
            viewModel.init(handle)
        }
        return viewModel as T
    }

}