package com.example.talentomobiletechtest.feature.details.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import com.example.talentomobiletechtest.common.view.viewmodel.BaseViewModel
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.details.domain.usecase.RequestCenterDetailsUseCase

class CenterDetailsViewModel(
    private val requestCenterDetailsUseCase: RequestCenterDetailsUseCase
) : BaseViewModel() {

    var detailsAlreadyRequested: Boolean = false

    private var _centerDetails = MutableLiveData<Resource<Center>>()
    val centerDetails: LiveData<Resource<Center>>
        get() = _centerDetails

    fun requestCentersDetails(centerUrlId: String, showLoading: Boolean = true) {
        if (showLoading) {
            _centerDetails.postValue(Resource.Loading)
        }
        requestCenterDetailsUseCase.setDetailUrlId(centerUrlId)
        runUseCase(requestCenterDetailsUseCase, createRequestCenterDetailsObservable())
    }

    private fun createRequestCenterDetailsObservable(): BaseObserver<Center> =
        object : BaseObserver<Center>() {
            override fun onNext(value: Center) {
                _centerDetails.postValue(Resource.Success(value))
            }

            override fun onError(e: Throwable) {
                _centerDetails.postValue(Resource.UnknownError(e))
            }

            override fun onComplete() {
                // no op
            }

        }

}