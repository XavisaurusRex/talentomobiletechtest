package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RequestFeedCentersUseCaseImpl(
    private val requestCentersForHomelessPeopleUseCase: RequestCentersForHomelessPeopleUseCase,
    private val requestJuvenileAndFamilyCareCentersUseCase: RequestJuvenileAndFamilyCareCentersUseCase,
) : RequestFeedCentersUseCase {


    override fun buildObservable(): Observable<List<CenterDataWrapper>> =
        requestJuvenileAndFamilyCareCentersUseCase.buildObservable()
            .subscribeOn(Schedulers.io())
            .zipWith(
                requestCentersForHomelessPeopleUseCase.buildObservable()
                    .subscribeOn(Schedulers.io()),
                { t, u ->
                    val mergeCenters: ArrayList<CenterDataWrapper> = arrayListOf()
                    // TODO: 3/2/21 ADD Strategy to order by name on merge responses.
                    mergeCenters.addAll(t)
                    mergeCenters.addAll(u)
                    mergeCenters
                })
}