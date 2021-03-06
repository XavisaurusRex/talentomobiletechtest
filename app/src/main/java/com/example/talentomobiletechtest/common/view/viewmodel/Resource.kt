package com.example.talentomobiletechtest.common.view.viewmodel

sealed class Resource<out R> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class UnknownError(val throwable: Throwable = Exception()) : Resource<Nothing>()
}