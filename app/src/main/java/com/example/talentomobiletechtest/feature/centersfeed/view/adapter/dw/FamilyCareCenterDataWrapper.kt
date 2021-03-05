package com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw

import android.os.Parcel
import android.os.Parcelable
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

class FamilyCareCenterDataWrapper(center: Center) : CenterDataWrapper(center) {

    override val viewType: Int = VIEW_TYPE_FAMILY_CARE_CENTER

    constructor(parcel: Parcel) : this(
        parcel.readParcelable<Center>(Center::class.java.classLoader)!!
    )

    companion object CREATOR : Parcelable.Creator<FamilyCareCenterDataWrapper> {
        override fun createFromParcel(parcel: Parcel): FamilyCareCenterDataWrapper {
            return FamilyCareCenterDataWrapper(parcel)
        }

        override fun newArray(size: Int): Array<FamilyCareCenterDataWrapper?> {
            return arrayOfNulls(size)
        }
    }
}