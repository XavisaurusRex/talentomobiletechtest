package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw

class HomelessCenterDataWrapper(var item: Item) : CenterDataWrapper() {

    override val viewType: Int = VIEW_TYPE_HOMELESS_CENTER

    data class Item(
        val id: String,
        val name: String
    )
}