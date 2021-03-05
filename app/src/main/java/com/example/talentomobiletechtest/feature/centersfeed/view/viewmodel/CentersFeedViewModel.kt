package com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import com.example.talentomobiletechtest.common.view.viewmodel.BaseViewModel
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper

class CentersFeedViewModel(
    private val requestFeedCentersUseCase: RequestFeedCentersUseCase
) : BaseViewModel() {

    private var _availableCenters = MutableLiveData<List<CenterDataWrapper>>()
    val availableCenters: LiveData<List<CenterDataWrapper>>
        get() = _availableCenters

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private var _error = MutableLiveData<Pair<Boolean, String?>>()
    val error: LiveData<Pair<Boolean, String?>> get() = _error

    override fun init(savedStateHandle: SavedStateHandle) {
        _availableCenters = savedStateHandle.getLiveData(SAVED_STATE_AVAILABLE_CENTERS)
        _loading = savedStateHandle.getLiveData(SAVED_STATE_LOADING)
        _error = savedStateHandle.getLiveData(SAVED_STATE_ERROR)

        if(_availableCenters.value.isNullOrEmpty()){
            _error.postValue(false to null)
            _loading.postValue(true)
            runUseCase(requestFeedCentersUseCase, createRequestFeedCentersObserver())
        }
    }

    private fun createRequestFeedCentersObserver(): BaseObserver<List<CenterDataWrapper>> {
        return object : BaseObserver<List<CenterDataWrapper>>() {
            override fun onNext(value: List<CenterDataWrapper>) {
                _loading.postValue(false)
                _availableCenters.postValue(value)
            }

            override fun onError(e: Throwable) {
                _loading.postValue(false)
                _error.postValue(true to e.message)
            }

            override fun onComplete() {
                // no op
            }
        }
    }

    companion object {
        const val SAVED_STATE_AVAILABLE_CENTERS = "availableCenters"
        const val SAVED_STATE_LOADING = "loading"
        const val SAVED_STATE_ERROR = "error"
    }
}