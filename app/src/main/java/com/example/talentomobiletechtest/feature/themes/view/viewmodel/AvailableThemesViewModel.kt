package com.example.talentomobiletechtest.feature.themes.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.talentomobiletechtest.common.domain.ResponseWrapper
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AvailableThemesViewModel(
    private val getAvailableThemesUseCase: GetAvailableThemesUseCase
) : ViewModel() {

    var themesAlreadyRequested: Boolean = false

    private var _availableThemesList = MutableLiveData<Resource<List<ThemeDataWrapper>>>()
    val availableThemesList: LiveData<Resource<List<ThemeDataWrapper>>>
        get() = _availableThemesList

    fun updateThemesList(showLoading: Boolean = true) {
        viewModelScope.launch(Dispatchers.IO) {
            if (showLoading) {
                _availableThemesList.postValue(Resource.Loading)
            }
            _availableThemesList.postValue(requestAvailableThemes())
        }
    }

    private suspend fun requestAvailableThemes(): Resource<List<ThemeDataWrapper>> {
        val availableThemes = getAvailableThemesUseCase.execute()
        return if (availableThemes is ResponseWrapper.Success) {
            Resource.Success(availableThemes.data)
        } else {
            Resource.UnknownError()
        }
    }
}