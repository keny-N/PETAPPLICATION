package jp.ac.asojuku.st.petapplication

import android.os.Parcel
import android.os.Parcelable

class Pet(pet_dec:Int,pet_border:Int,pet_png:String):Parcelable {
    var pet_png:String = ""
    var pet_dec:Int = 0
    var pet_water:Int = 100
    var pet_love:Int = 0
    var pet_border = 0
    var pet_name = ""

    constructor(parcel: Parcel) : this(
        TODO("pet_png"),
        TODO("pet_dec"),
        TODO("pet_border"),
        TODO("pet_name")
    ) {
        pet_png = parcel.readString()
        pet_dec = parcel.readInt()
        pet_water = parcel.readInt()
        pet_love = parcel.readInt()
        pet_border = parcel.readInt()
        pet_name = parcel.readString()
    }

    init {
        this.pet_png = pet_png
        this.pet_dec = pet_dec
        this.pet_border = pet_border
        this.pet_name = pet_name

    }
    fun water_inc(water:Int){
        this.pet_water += water
    }
    fun love_inc(love:Int){
        this.pet_love += love
    }

    fun tick(){
        pet_water -= pet_dec
        if(pet_water<=0){

        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pet_png)
        parcel.writeInt(pet_dec)
        parcel.writeInt(pet_water)
        parcel.writeInt(pet_love)
        parcel.writeInt(pet_border)
        parcel.writeString(pet_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }
}