package com.example.talentomobiletechtest.feature.themes.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import com.example.talentomobiletechtest.common.view.viewmodel.BaseViewModel
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase

class AvailableThemesViewModel(
    private val requestFeedCentersUseCase: RequestFeedCentersUseCase
) : BaseViewModel() {

    var themesAlreadyRequested: Boolean = false

    private var _availableCenters = MutableLiveData<Resource<List<Center>>>()
    val availableCenters: LiveData<Resource<List<Center>>>
        get() = _availableCenters

    fun updateCentersList(showLoading: Boolean = true) {
        if (showLoading) {
            _availableCenters.postValue(Resource.Loading)
        }
        runUseCase(requestFeedCentersUseCase, createRequestFeedCentersObserver())
    }

    private fun createRequestFeedCentersObserver(): BaseObserver<in List<Center>> {
        return object : BaseObserver<List<Center>>() {
            override fun onNext(value: List<Center>) {
                _availableCenters.postValue(Resource.Success(value))
            }

            override fun onError(e: Throwable) {
                Log.d("createAveThemesObserver", "onError -> ", e)
                _availableCenters.postValue(Resource.UnknownError(e))
            }

            override fun onComplete() {
                // no op
            }
        }
    }
}