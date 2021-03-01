package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import android.util.Log
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import io.reactivex.Observable

class RequestCentersForHomelessPeopleUseCaseImpl(
    private val repository: CentersRepository
) : RequestCentersForHomelessPeopleUseCase {

    // Consider return BaseDataWrappers in this level
    override fun buildObservable(): Observable<List<Center>> =
        Observable.fromCallable {
            val list = repository.requestCentersForHomelessPeople()
            Log.d(
                "ObservableUseCase",
                "\n---------------------\nRequestCentersForHomelessPeopleUseCase - > Success\nSize ->${list.size}\n$list"
            )
            list
        }
}