package com.example.talentomobiletechtest.feature.themes.view.adapter.dw

import com.example.talentomobiletechtest.common.view.adapter.dw.BaseDataWrapper

class ThemeDataWrapper(
    val id: String,
    val titles: List<String>
) : BaseDataWrapper() {
    override val viewType: Int = 777
}