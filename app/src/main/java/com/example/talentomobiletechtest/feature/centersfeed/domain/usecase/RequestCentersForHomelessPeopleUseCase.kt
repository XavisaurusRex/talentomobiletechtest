package com.example.talentomobiletechtest.feature.centersfeed.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.HomelessCenterDataWrapper

interface RequestCentersForHomelessPeopleUseCase :
    BaseObservableUseCase<List<HomelessCenterDataWrapper>>