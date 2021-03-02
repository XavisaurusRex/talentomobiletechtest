package com.example.talentomobiletechtest.feature.themes.view.adapter.dw

class FamilyCareCenterDataWrapper(val item: Item) : CenterDataWrapper() {

    data class Item(val name: String)

    override val viewType: Int = VIEW_TYPE_FAMILY_CARE_CENTER

}