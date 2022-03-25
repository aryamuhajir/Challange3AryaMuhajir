package com.binar.challange3

import android.os.Parcel
import android.os.Parcelable

data class DataPerson(var nama : String?, var usia : Int, var alamat : String?, var pekerjaan : String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(usia)
        parcel.writeString(alamat)
        parcel.writeString(pekerjaan)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataPerson> {
        override fun createFromParcel(parcel: Parcel): DataPerson {
            return DataPerson(parcel)
        }

        override fun newArray(size: Int): Array<DataPerson?> {
            return arrayOfNulls(size)
        }
    }
}
