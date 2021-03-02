package com.example.talentomobiletechtest.common.view.adapter.vh

import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.example.talentomobiletechtest.common.view.adapter.dw.BaseDataWrapper
import com.example.talentomobiletechtest.common.view.adapter.listener.BaseAdapterListener

abstract class BaseViewHolder<DW : BaseDataWrapper, LT : BaseAdapterListener<DW>>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    abstract fun bindViewHolder(dataWrapper: DW, listener: LT?, position: Int)

    open fun onViewAttachedToWindow(listener: LT?) {}

    protected fun getString(@StringRes stringId: Int): String = itemView.context.getString(stringId)

}