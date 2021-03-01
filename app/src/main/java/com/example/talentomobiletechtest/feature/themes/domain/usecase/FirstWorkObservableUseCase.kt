package com.example.talentomobiletechtest.feature.themes.domain.usecase

import android.util.Log
import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import io.reactivex.Observable

class FirstWorkObservableUseCase() : BaseObservableUseCase<List<ThemeDataWrapper>> {


    override fun buildObservable(): Observable<List<ThemeDataWrapper>> =
        Observable.fromCallable {
            val time = 5000L
            Log.d("Thread", "FirstWorkObservableUseCase - Taked time to end -> $time")
            Thread.sleep(time)

            listOf(
                ThemeDataWrapper(
                    "FirstWorkObservableUseCase",
                    listOf("FirstWorkObservableUseCase")
                ),
                ThemeDataWrapper(
                    "FirstWorkObservableUseCase1",
                    listOf("FirstWorkObservableUseCase1")
                ),
                ThemeDataWrapper(
                    "FirstWorkObservableUseCase1",
                    listOf("FirstWorkObservableUseCase1")
                ),
                ThemeDataWrapper(
                    "FirstWorkObservableUseCase1",
                    listOf("FirstWorkObservableUseCase1")
                ),
                ThemeDataWrapper(
                    "FirstWorkObservableUseCase1",
                    listOf("FirstWorkObservableUseCase1")
                )
            )
        }
}