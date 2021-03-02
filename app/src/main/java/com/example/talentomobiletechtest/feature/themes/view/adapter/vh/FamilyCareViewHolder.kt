package com.example.talentomobiletechtest.feature.themes.view.adapter.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.talentomobiletechtest.databinding.ViewholderCenterFamilycareBinding
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.adapter.listener.CenterAdapterListener

class FamilyCareViewHolder(parent: ViewGroup) : CenterViewHolder(
    ViewholderCenterFamilycareBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ).root
) {
    private val binding: ViewholderCenterFamilycareBinding by lazy {
        ViewholderCenterFamilycareBinding.bind(itemView)
    }

    override fun bindViewHolder(
        dataWrapper: CenterDataWrapper,
        listener: CenterAdapterListener?,
        position: Int
    ) {
        dataWrapper as FamilyCareCenterDataWrapper

        binding.tvCenterTitle.text = dataWrapper.item.name
        binding.tvCenterSubtitle.text = "Subtitle -> " + dataWrapper.item.name

        itemView.setOnClickListener {
            listener?.onFamilyCareCenterClicked(dataWrapper)
        }
    }


}