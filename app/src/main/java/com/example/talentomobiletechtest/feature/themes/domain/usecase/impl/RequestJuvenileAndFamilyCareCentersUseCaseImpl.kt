package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import android.util.Log
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import io.reactivex.Observable

class RequestJuvenileAndFamilyCareCentersUseCaseImpl(
    private val repository: CentersRepository
) : RequestJuvenileAndFamilyCareCentersUseCase {

    // Consider return BaseDataWrappers in this level
    override fun buildObservable(): Observable<List<Center>> =
        Observable.fromCallable {
            val list = repository.requestJuvenileAndFamilyCareCenters()
            Log.d(
                "ObservableUseCase",
                "\n---------------------\nRequestJuvenileAndFamilyCareCentersUseCase - > Success\nSize ->${list.size}\n$list"
            )
            list
        }
}