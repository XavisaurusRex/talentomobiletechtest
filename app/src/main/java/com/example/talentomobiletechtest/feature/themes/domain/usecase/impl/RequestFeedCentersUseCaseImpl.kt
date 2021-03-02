package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.HomelessCenterDataWrapper
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
                { left, right ->
                    val mergeCenters: ArrayList<CenterDataWrapper> = arrayListOf()
                    mergeCenters.addAll(left)
                    mergeCenters.addAll(right)
                    return@zipWith mergeCenters.sortedBy {
                        when (it.viewType) {
                            CenterDataWrapper.VIEW_TYPE_FAMILY_CARE_CENTER -> (it as FamilyCareCenterDataWrapper).item.name
                            else -> (it as HomelessCenterDataWrapper).item.name
                        }
                    }
                })
}