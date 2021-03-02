package com.example.talentomobiletechtest.feature.themes.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.HomelessCenterDataWrapper

interface RequestCentersForHomelessPeopleUseCase :
    BaseObservableUseCase<List<HomelessCenterDataWrapper>>