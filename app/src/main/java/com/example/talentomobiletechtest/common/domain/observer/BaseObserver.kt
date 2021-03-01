package com.example.talentomobiletechtest.common.domain.observer

import io.reactivex.observers.DisposableObserver

abstract class BaseObserver<T> : DisposableObserver<T>()