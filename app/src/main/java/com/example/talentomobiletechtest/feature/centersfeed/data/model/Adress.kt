package com.example.talentomobiletechtest.feature.centersfeed.data.model

import android.os.Parcel
import android.os.Parcelable

data class Adress(
    val locality: String?,
    val postalCode: String?,
    val streetAddress: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(locality)
        parcel.writeString(postalCode)
        parcel.writeString(streetAddress)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Adress> {
        override fun createFromParcel(parcel: Parcel): Adress {
            return Adress(parcel)
        }

        override fun newArray(size: Int): Array<Adress?> {
            return arrayOfNulls(size)
        }
    }
}
