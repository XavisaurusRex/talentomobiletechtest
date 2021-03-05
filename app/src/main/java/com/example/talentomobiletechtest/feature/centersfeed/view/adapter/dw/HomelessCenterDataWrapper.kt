package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw

import android.os.Parcel
import android.os.Parcelable
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

class HomelessCenterDataWrapper(center: Center) : CenterDataWrapper(center) {

    override val viewType: Int = VIEW_TYPE_HOMELESS_CENTER

    constructor(parcel: Parcel) : this(
        parcel.readParcelable<Center>(Center::class.java.classLoader)!!
    )

    companion object CREATOR : Parcelable.Creator<HomelessCenterDataWrapper> {
        override fun createFromParcel(parcel: Parcel): HomelessCenterDataWrapper {
           return HomelessCenterDataWrapper(parcel)
        }

        override fun newArray(size: Int): Array<HomelessCenterDataWrapper?> {
            return arrayOfNulls(size)
        }
    }
}