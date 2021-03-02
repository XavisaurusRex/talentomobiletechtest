package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestCentersForHomelessPeopleUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.HomelessCenterDataWrapper
import io.reactivex.Observable

class RequestCentersForHomelessPeopleUseCaseImpl(
    private val repository: CentersRepository
) : RequestCentersForHomelessPeopleUseCase {

    override fun buildObservable(): Observable<List<HomelessCenterDataWrapper>> =
        Observable.fromCallable {
            val list = repository.requestCentersForHomelessPeople()
            val elements = arrayListOf<HomelessCenterDataWrapper>()
            for (element in list) {
                elements.add(
                    HomelessCenterDataWrapper(
                        HomelessCenterDataWrapper.Item(element.name)
                    )
                )
            }

            elements
        }
}