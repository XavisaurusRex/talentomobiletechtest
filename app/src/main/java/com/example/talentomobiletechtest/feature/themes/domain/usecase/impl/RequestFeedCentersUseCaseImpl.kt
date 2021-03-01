package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import android.util.Log
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RequestFeedCentersUseCaseImpl(
    private val requestCentersForHomelessPeopleUseCase: RequestCentersForHomelessPeopleUseCase,
    private val requestJuvenileAndFamilyCareCentersUseCase: RequestJuvenileAndFamilyCareCentersUseCase,
) : RequestFeedCentersUseCase {


    override fun buildObservable(): Observable<List<Center>> =
        requestJuvenileAndFamilyCareCentersUseCase.buildObservable()
            .subscribeOn(Schedulers.io())
            .zipWith(
                requestCentersForHomelessPeopleUseCase.buildObservable()
                    .subscribeOn(Schedulers.io()),
                { t, u ->
                    val mergeCenters = t.toMutableList()
                    mergeCenters.addAll(u)
                    Log.d(
                        "ObservableUseCase",
                        "\n---------------------\nRequestFeedCentersUseCase - > Success\nSize ->${mergeCenters.size}\n$mergeCenters"
                    )
                    mergeCenters
                })
}