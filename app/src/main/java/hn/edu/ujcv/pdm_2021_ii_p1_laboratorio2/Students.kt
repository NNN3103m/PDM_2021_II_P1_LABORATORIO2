package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.os.Parcel
import android.os.Parcelable

class Students() : Parcelable {
//    Variables
    var AccNumber:Int = 0
    var StntName:String = ""
    var StntMail:String = ""

    constructor(parcel: Parcel) : this() {
        AccNumber = parcel.readInt()
        StntName = parcel.readString().toString()
        StntMail = parcel.readString().toString()
    }


    constructor(accNumber : Int, StntName : String,stntMail: String) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(AccNumber)
        parcel.writeString(StntName)
        parcel.writeString(StntMail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Students> {
        override fun createFromParcel(parcel: Parcel): Students {
            return Students(parcel)
        }

        override fun newArray(size: Int): Array<Students?> {
            return arrayOfNulls(size)
        }

        var Students:HashMap<Int, Students> = hashMapOf()
        var Enrollment: HashMap<Students, ArrayList<Classes>> = hashMapOf()
    }

    override fun toString(): String {
        return "Nombre del Alumno: $StntName\nNumero de Cuenta: $AccNumber"
    }

}