package com.jararat.actividad_1

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
/*
class Heroe  : Serializable {
     var nombre:String?,
     var power:Float?
     var img:Bitmap

    constructor(nombre: String, power: Float?, img: Bitmap) {
        this.nombre = nombre
        this.power = power
        this.img = img
    }
}*/

data class Heroe(
    var nombre:String?,
    var power:Float?,
    var img:Bitmap?
):Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readParcelable(Bitmap::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeValue(power)
        parcel.writeParcelable(img, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Heroe> {
        override fun createFromParcel(parcel: Parcel): Heroe {
            return Heroe(parcel)
        }

        override fun newArray(size: Int): Array<Heroe?> {
            return arrayOfNulls(size)
        }
    }

}