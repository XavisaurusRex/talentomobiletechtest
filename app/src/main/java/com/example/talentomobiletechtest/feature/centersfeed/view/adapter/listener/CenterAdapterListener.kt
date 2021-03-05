package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener

import com.example.talentomobiletechtest.common.view.adapter.listener.BaseAdapterListener
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.HomelessCenterDataWrapper

interface CenterAdapterListener : BaseAdapterListener<CenterDataWrapper> {

    fun onCenterClicked(center: Center)

}
