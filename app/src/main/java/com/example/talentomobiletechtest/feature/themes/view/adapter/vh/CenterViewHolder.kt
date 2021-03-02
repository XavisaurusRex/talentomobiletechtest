package com.example.talentomobiletechtest.feature.themes.view.adapter.vh

import android.view.View
import com.example.talentomobiletechtest.common.view.adapter.vh.BaseViewHolder
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.listener.CenterAdapterListener

abstract class CenterViewHolder(itemView: View) :
    BaseViewHolder<CenterDataWrapper, CenterAdapterListener>(
        itemView
    ) {

    companion object {
        const val VIEW_TYPE_FAMILY_CARE_CENTER = 135
        const val VIEW_TYPE_HOMELESS_CENTER = 136
    }

}