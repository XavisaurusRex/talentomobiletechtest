package com.example.talentomobiletechtest.feature.themes.domain.usecase

import android.util.Log
import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemes
import io.reactivex.Observable

class SecondWorkObservableUseCase() : BaseObservableUseCase<List<ApiThemes>> {


    override fun buildObservable(): Observable<List<ApiThemes>> =
        Observable.fromCallable {
            val time = 7000L
            Log.d("Thread", "SecondWorkObservableUseCase - Taked time to end -> $time")
            Thread.sleep(time)

            listOf(
                ApiThemes(
                    "SecondWorkObservableUseCase",
                    "SecondWorkObservableUseCase",
                    listOf("SecondWorkObservableUseCase")
                ),
                ApiThemes(
                    "SecondWorkObservableUseCase1",
                    "SecondWorkObservableUseCase1",
                    listOf("SecondWorkObservableUseCase1")
                ),
                ApiThemes(
                    "SecondWorkObservableUseCase1",
                    "SecondWorkObservableUseCase1",
                    listOf("SecondWorkObservableUseCase1")
                ),
                ApiThemes(
                    "SecondWorkObservableUseCase1",
                    "SecondWorkObservableUseCase1",
                    listOf("SecondWorkObservableUseCase1")
                )
            )
        }
}