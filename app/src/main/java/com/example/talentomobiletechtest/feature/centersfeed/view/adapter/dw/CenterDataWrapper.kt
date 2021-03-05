package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw

import android.os.Parcel
import com.example.talentomobiletechtest.common.view.adapter.dw.BaseDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

abstract class CenterDataWrapper(val center: Center) : BaseDataWrapper() {

    companion object {
        const val VIEW_TYPE_FAMILY_CARE_CENTER = 135
        const val VIEW_TYPE_HOMELESS_CENTER = 136
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(center, flags)
    }

    override fun describeContents(): Int {
        return 0
    }
}