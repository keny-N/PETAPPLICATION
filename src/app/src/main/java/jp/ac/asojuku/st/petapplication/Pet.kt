package jp.ac.asojuku.st.petapplication

import android.annotation.SuppressLint
import android.os.Parcel
import android.util.Log

import java.io.Serializable

class Pet(dec:Int, love_rate:Int, png:String):Serializable{
    var pet_png:String = ""
    var pet_dec:Int = 0
    var pet_water:Int = 100
    var pet_love:Int = 0
    var pet_love_rate= 0
    var pet_name = ""

    init {
        this.pet_png = png
        this.pet_dec = dec
        this.pet_love_rate = love_rate
    }
    fun water_inc(water:Int):Int{
        this.pet_water += water
        if(this.pet_water>100){
            pet_water=100
        }
        return  pet_water
    }
    fun love_inc(love:Int):Int{
        this.pet_love += (love * pet_love_rate) / 100
        if(this.pet_love>100){
            pet_love=100
        }
        Log.d("love",pet_love.toString())
        return  pet_love

    }

    fun tick(){
        pet_water -= pet_dec
        if(pet_water<=0){

        }
    }


}