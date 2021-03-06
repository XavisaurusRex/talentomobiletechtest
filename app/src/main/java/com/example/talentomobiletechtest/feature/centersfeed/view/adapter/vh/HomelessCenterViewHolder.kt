package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.vh

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.talentomobiletechtest.databinding.ViewholderCenterHomelessBinding
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener.CenterAdapterListener

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
        binding.tvCenterTitle.text = dataWrapper.center.title
        binding.tvCenterSubtitle.text = "Subtitle -> " + dataWrapper.center.title

        itemView.setOnClickListener {
            listener?.onCenterClicked(dataWrapper.center)
        }
    }


}