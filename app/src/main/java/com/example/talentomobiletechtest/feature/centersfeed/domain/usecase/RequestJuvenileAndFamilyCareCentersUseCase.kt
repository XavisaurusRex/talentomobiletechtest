package com.example.talentomobiletechtest.feature.centersfeed.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.FamilyCareCenterDataWrapper

interface RequestJuvenileAndFamilyCareCentersUseCase :
    BaseObservableUseCase<List<FamilyCareCenterDataWrapper>>