package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.os.Parcel
import android.os.Parcelable

class Classes () : Parcelable {
//    Variables
    var CCode   = 0
    var CName   = ""
    var CSection  = ""
    var CTime     = ""
    var CLocation = ""
    var gradesI       = 0.0
    var gradesII       = 0.0
    var gradesIII       = 0.0

    constructor(parcel: Parcel) : this() {
        CCode = parcel.readInt()
        CName = parcel.readString().toString()
        CSection = parcel.readString().toString()
        CTime = parcel.readString().toString()
        CLocation = parcel.readString().toString()
        gradesI = parcel.readDouble()
        gradesII = parcel.readDouble()
        gradesIII = parcel.readDouble()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(CCode)
        parcel.writeString(CName)
        parcel.writeString(CSection)
        parcel.writeString(CTime)
        parcel.writeString(CLocation)
        parcel.writeDouble(gradesI)
        parcel.writeDouble(gradesII)
        parcel.writeDouble(gradesIII)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Classes> {
        override fun createFromParcel(parcel: Parcel): Classes {
            return Classes(parcel)
        }

        override fun newArray(size: Int): Array<Classes?> {
            return arrayOfNulls(size)
        }

        var Classes: HashMap<Int, Classes> = hashMapOf()
    }

    fun SendNotes(): String{
        return "Clase: $CName\nNota Primer Parcial: $gradesI\nNota Segundo Parcial: $gradesII\nNota Tercer Parcial: $gradesIII\n"
    }

    override fun toString(): String {
        return "classCode : ${CCode}\nClase: $CName\nSeccion: $CSection\nHora: $CTime\nEdificio: $CLocation\n"
    }

}
