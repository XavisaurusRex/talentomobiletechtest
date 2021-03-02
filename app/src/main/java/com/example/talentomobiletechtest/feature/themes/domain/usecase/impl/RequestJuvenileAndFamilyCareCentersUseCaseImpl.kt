package com.example.talentomobiletechtest.feature.themes.domain.usecase.impl

import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository
import com.example.talentomobiletechtest.feature.themes.domain.usecase.RequestJuvenileAndFamilyCareCentersUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper
import io.reactivex.Observable

class RequestJuvenileAndFamilyCareCentersUseCaseImpl(
    private val repository: CentersRepository
) : RequestJuvenileAndFamilyCareCentersUseCase {

    override fun buildObservable(): Observable<List<FamilyCareCenterDataWrapper>> =
        Observable.fromCallable {
            val list = repository.requestJuvenileAndFamilyCareCenters()
            val elements = arrayListOf<FamilyCareCenterDataWrapper>()
            for (element in list) {
                elements.add(
                    FamilyCareCenterDataWrapper(
                        FamilyCareCenterDataWrapper.Item(element.name)
                    )
                )
            }

            elements
        }
}