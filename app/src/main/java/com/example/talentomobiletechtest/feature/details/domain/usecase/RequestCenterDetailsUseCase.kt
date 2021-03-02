package com.example.talentomobiletechtest.feature.details.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

interface RequestCenterDetailsUseCase : BaseObservableUseCase<Center> {
    fun setDetailUrlId(urlId: String)
}