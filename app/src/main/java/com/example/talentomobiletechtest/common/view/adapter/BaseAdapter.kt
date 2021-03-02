package com.example.talentomobiletechtest.common.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.talentomobiletechtest.common.view.adapter.dw.BaseDataWrapper
import com.example.talentomobiletechtest.common.view.adapter.listener.BaseAdapterListener
import com.example.talentomobiletechtest.common.view.adapter.vh.BaseViewHolder

abstract class BaseAdapter<DW, VH, LT> : RecyclerView.Adapter<VH>()
        where DW : BaseDataWrapper, VH : BaseViewHolder<DW, LT>, LT : BaseAdapterListener<DW> {

    protected abstract val data: List<DW>
    var listener: LT? = null

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindViewHolder(data[position], listener, position)
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow(listener)
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].viewType
}