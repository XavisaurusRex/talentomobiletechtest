package com.example.talentomobiletechtest.feature.centersfeed.view.adapter

import android.view.ViewGroup
import com.example.talentomobiletechtest.common.view.adapter.BaseAdapter
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper.Companion.VIEW_TYPE_FAMILY_CARE_CENTER
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener.CenterAdapterListener
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.vh.CenterViewHolder
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.vh.FamilyCareViewHolder
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.vh.HomelessCenterViewHolder

class CentersAdapter() : BaseAdapter<CenterDataWrapper, CenterViewHolder, CenterAdapterListener>() {

    override val data: ArrayList<CenterDataWrapper> = arrayListOf()

    constructor(listener: CenterAdapterListener, dataWrappers: List<CenterDataWrapper>) : this() {
        this.listener = listener
        data.addAll(dataWrappers)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CenterViewHolder {
        return when (viewType) {
            VIEW_TYPE_FAMILY_CARE_CENTER -> FamilyCareViewHolder(parent)
            else -> HomelessCenterViewHolder(parent)
        }
    }

}