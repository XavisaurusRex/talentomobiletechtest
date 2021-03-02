package com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import com.example.talentomobiletechtest.common.view.viewmodel.BaseViewModel
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper

class CentersFeedViewModel(
    private val requestFeedCentersUseCase: RequestFeedCentersUseCase
) : BaseViewModel() {

    var themesAlreadyRequested: Boolean = false

    private var _availableCenters = MutableLiveData<Resource<List<CenterDataWrapper>>>()
    val availableCenter: LiveData<Resource<List<CenterDataWrapper>>>
        get() = _availableCenters

    fun updateCentersList(showLoading: Boolean = true) {
        if (showLoading) {
            _availableCenters.postValue(Resource.Loading)
        }
        runUseCase(requestFeedCentersUseCase, createRequestFeedCentersObserver())
    }

    private fun createRequestFeedCentersObserver(): BaseObserver<List<CenterDataWrapper>> {
        return object : BaseObserver<List<CenterDataWrapper>>() {
            override fun onNext(value: List<CenterDataWrapper>) {
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