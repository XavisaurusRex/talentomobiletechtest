package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.vh

import android.view.View
import com.example.talentomobiletechtest.common.view.adapter.vh.BaseViewHolder
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener.CenterAdapterListener

abstract class CenterViewHolder(itemView: View) :
    BaseViewHolder<CenterDataWrapper, CenterAdapterListener>(
        itemView
    )