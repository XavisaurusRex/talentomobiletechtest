package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw

class FamilyCareCenterDataWrapper(val item: Item) : CenterDataWrapper() {

    override val viewType: Int = VIEW_TYPE_FAMILY_CARE_CENTER

    data class Item(
        val id: String,
        val name: String
    )

}