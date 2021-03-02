package com.example.talentomobiletechtest.feature.themes.domain.usecase

import com.example.talentomobiletechtest.common.domain.observable.BaseObservableUseCase
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper

interface RequestJuvenileAndFamilyCareCentersUseCase :
    BaseObservableUseCase<List<FamilyCareCenterDataWrapper>>