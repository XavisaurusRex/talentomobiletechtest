package com.example.talentomobiletechtest.feature.centersfeed.data.model

import android.os.Parcel
import android.os.Parcelable

data class Organization(
    val organizationDesc: String?,
    val schedule: String?,
    val services: String?,
    val organizationName: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(organizationDesc)
        parcel.writeString(schedule)
        parcel.writeString(services)
        parcel.writeString(organizationName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Organization> {
        override fun createFromParcel(parcel: Parcel): Organization {
            return Organization(parcel)
        }

        override fun newArray(size: Int): Array<Organization?> {
            return arrayOfNulls(size)
        }
    }
}
