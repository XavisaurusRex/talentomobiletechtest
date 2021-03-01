package com.example.talentomobiletechtest.feature.themes.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import com.example.talentomobiletechtest.common.view.viewmodel.BaseViewModel
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.feature.themes.domain.usecase.FirstWorkObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesObservableUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.SecondWorkObservableUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AvailableThemesViewModel(
    private val getAvailableThemesUseCase: GetAvailableThemesObservableUseCase,
    private val firstWorkObservableUseCase: FirstWorkObservableUseCase,
    private val secondWorkObservableUseCase: SecondWorkObservableUseCase
) : BaseViewModel() {

    var themesAlreadyRequested: Boolean = false

    private var _availableThemesList = MutableLiveData<Resource<List<ThemeDataWrapper>>>()
    val availableThemesList: LiveData<Resource<List<ThemeDataWrapper>>>
        get() = _availableThemesList

    fun updateThemesList(showLoading: Boolean = true) {
        if (showLoading) {
            _availableThemesList.postValue(Resource.Loading)
        }
        runUseCase(getAvailableThemesUseCase, createAvailableThemesObserver())
    }

    fun updateAllCenters(showLoading: Boolean) {

        firstWorkObservableUseCase.buildObservable().subscribeOn(Schedulers.io())
            .zipWith(
                secondWorkObservableUseCase.buildObservable().subscribeOn(Schedulers.io()),
                { t, u ->
                    val stringBuilder = StringBuilder()

                    t.forEach {
                        stringBuilder.append("THEMEDATAWRAPPER TITLE -> ${it.id}\n")
                    }
                    stringBuilder.append("---------------------------------\n")
                    u.forEach {
                        stringBuilder.append(it.toString())
                        stringBuilder.append("\n")
                    }

                    stringBuilder.toString()
                })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(createParallelWorkersObserver())
    }

    private fun createAvailableThemesObserver(): BaseObserver<List<ThemeDataWrapper>> {
        return object : BaseObserver<List<ThemeDataWrapper>>() {
            override fun onNext(value: List<ThemeDataWrapper>) {
                _availableThemesList.postValue(Resource.Success(value))
            }

            override fun onError(e: Throwable) {
                _availableThemesList.postValue(Resource.UnknownError(e))
            }

            override fun onComplete() {
                // no op
            }
        }
    }

    private fun createParallelWorkersObserver(): BaseObserver<String> =
        object : BaseObserver<String>() {
            override fun onNext(value: String) {
                Log.d("Thread", "FINISHED -> $value")
                _availableThemesList.postValue(Resource.UnknownError(Exception(value)))
            }

            override fun onError(e: Throwable) {
                _availableThemesList.postValue(Resource.UnknownError(e))
            }

            override fun onComplete() {
                // no op
            }

        }
}