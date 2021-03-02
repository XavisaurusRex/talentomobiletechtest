package com.example.talentomobiletechtest.common.domain.observable

import io.reactivex.Observable

interface BaseObservableUseCase<T> {
    fun buildObservable(): Observable<T>
}
