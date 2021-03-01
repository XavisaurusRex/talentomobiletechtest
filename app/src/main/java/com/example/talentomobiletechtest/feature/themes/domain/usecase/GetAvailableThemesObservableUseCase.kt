package com.example.talentomobiletechtest.feature.themes.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import io.reactivex.Observable

class GetAvailableThemesObservableUseCase(
    private val request: AvailableThemesRequest
) : BaseObservableUseCase<List<ThemeDataWrapper>> {


    override fun buildObservable(): Observable<List<ThemeDataWrapper>> =
        Observable.fromCallable {
            Thread.sleep(7000)
            val availableThemesResponseWrapper = request.getAvailableThemes()

            val themeDataWrappers: ArrayList<ThemeDataWrapper> = arrayListOf()
            availableThemesResponseWrapper.result.items.forEach {
                themeDataWrappers.add(
                    ThemeDataWrapper(
                        it.notation,
                        it.prefLabel
                    )
                )
            }
            themeDataWrappers
        }
}