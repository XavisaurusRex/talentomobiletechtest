package com.example.talentomobiletechtest.feature.details.domain.usecase.impl

import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.details.data.remote.CenterDetailsRepository
import com.example.talentomobiletechtest.feature.details.domain.usecase.RequestCenterDetailsUseCase
import io.reactivex.Observable

class RequestCenterDetailsUseCaseImpl(
    private val centerDetailsRepository: CenterDetailsRepository
) : RequestCenterDetailsUseCase {

    private lateinit var urlId: String

    override fun setDetailUrlId(urlId: String) {
        this.urlId = urlId
    }

    override fun buildObservable(): Observable<Center> {
        return Observable.fromCallable {
            Thread.sleep(3000)

            centerDetailsRepository.requestCenterDetails(urlId)
        }
    }
}