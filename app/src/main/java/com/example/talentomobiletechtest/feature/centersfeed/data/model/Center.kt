package com.example.talentomobiletechtest.feature.centersfeed.data.model

import android.os.Parcel
import android.os.Parcelable

data class Center(
    val refId: String?,
    val type: String?,
    val id: String?,
    val title: String?,
    val relation: String?,
    val address: Adress?,
    val location: Location?,
    val organization: Organization?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Adress::class.java.classLoader),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readParcelable(Organization::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(refId)
        parcel.writeString(type)
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(relation)
        parcel.writeParcelable(address, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeParcelable(organization, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Center> {
        override fun createFromParcel(parcel: Parcel): Center {
            return Center(parcel)
        }

        override fun newArray(size: Int): Array<Center?> {
            return arrayOfNulls(size)
        }
    }
}