package com.example.talentomobiletechtest.common.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.common.domain.observer.BaseObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun <T, U : BaseObservableUseCase<T>, O : BaseObserver<in T>> runUseCase(
        useCase: U,
        observer: O
    ) {
        compositeDisposable.add(
            useCase.buildObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
        )
    }
//
//    fun <T, U : BaseObservableUseCase<T>, O : BaseObserver<in T>> runUseCaseParallel(
//        vararg useCase: U,
//        observer: O
//    ) {
//
//        useCase[0].buildObservable()
//
//        compositeDisposable.add(
//            Observable.merge(
//                useCase[0].buildObservable().subscribeOn(Schedulers.io()),
//                useCase[1].buildObservable().subscribeOn(Schedulers.io()))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(observer)
//        )
//    }


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}