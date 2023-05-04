package com.bhavesh.fitpeoassignment.model

import android.os.Parcel
import android.os.Parcelable

data class ApiResponseItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String? = null,
    val title: String? = null,
    val url: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(albumId)
        parcel.writeInt(id)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiResponseItem> {
        override fun createFromParcel(parcel: Parcel): ApiResponseItem {
            return ApiResponseItem(parcel)
        }

        override fun newArray(size: Int): Array<ApiResponseItem?> {
            return arrayOfNulls(size)
        }
    }
}