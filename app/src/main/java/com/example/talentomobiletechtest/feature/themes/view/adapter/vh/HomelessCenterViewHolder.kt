package com.example.talentomobiletechtest.feature.themes.view.adapter.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.talentomobiletechtest.databinding.ViewholderCenterHomelessBinding
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.HomelessCenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.listener.CenterAdapterListener

class HomelessCenterViewHolder(parent: ViewGroup) : CenterViewHolder(
    ViewholderCenterHomelessBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).root
) {
    private val binding: ViewholderCenterHomelessBinding by lazy {
        ViewholderCenterHomelessBinding.bind(itemView)
    }

    override fun bindViewHolder(
        dataWrapper: CenterDataWrapper,
        listener: CenterAdapterListener?,
        position: Int
    ) {
        dataWrapper as HomelessCenterDataWrapper

        binding.tvCenterTitle.text = dataWrapper.item.name
        binding.tvCenterSubtitle.text = "Subtitle -> " + dataWrapper.item.name

        itemView.setOnClickListener {
            listener?.onHomelessCenterClicked(dataWrapper)
        }
    }


}