package com.example.talentomobiletechtest.feature.themes.view.adapter.listener

import com.example.talentomobiletechtest.common.view.adapter.listener.BaseAdapterListener
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.HomelessCenterDataWrapper

interface CenterAdapterListener : BaseAdapterListener<CenterDataWrapper> {

    fun onHomelessCenterClicked(homelessCenterDataWrapper: HomelessCenterDataWrapper)

    fun onFamilyCareCenterClicked(familyCareCenterDataWrapper: FamilyCareCenterDataWrapper)

}
