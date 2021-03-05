package com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.impl

import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestFeedCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RequestFeedCentersUseCaseImpl(
    private val requestCentersForHomelessPeopleUseCase: RequestCentersForHomelessPeopleUseCase,
    private val requestJuvenileAndFamilyCareCentersUseCase: RequestJuvenileAndFamilyCareCentersUseCase,
) : RequestFeedCentersUseCase {

    // TODO: 3/2/21 Improve way that capture errors from usecaseSources
    override fun buildObservable(): Observable<List<CenterDataWrapper>> =
        Observable.zip(
            requestJuvenileAndFamilyCareCentersUseCase
                .buildObservable()
                .subscribeOn(Schedulers.io())
                .onErrorReturn { arrayListOf() },
            requestCentersForHomelessPeopleUseCase
                .buildObservable()
                .subscribeOn(Schedulers.io())
                .onErrorReturn { arrayListOf() },
            { left, right ->
                val mergeCenters: ArrayList<CenterDataWrapper> = arrayListOf()
                mergeCenters.addAll(left)
                mergeCenters.addAll(right)

                if (mergeCenters.isEmpty()) {
                    throw Exception()
                }

                mergeCenters.sortedBy { it.center.title }
            }
        )
}