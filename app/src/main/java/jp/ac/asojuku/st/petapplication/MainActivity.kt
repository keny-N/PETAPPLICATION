package jp.ac.asojuku.st.petapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pet = Pet(1,1,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        choise_1.setOnClickListener { pet = Pet(1,100,"here1")}
        choise_2.setOnClickListener { pet = Pet(2,80,"here2")}
        choise_3.setOnClickListener { pet = Pet(3,60,"here3")}
        choise_4.setOnClickListener { pet = Pet(4,50,"here4")}
        choise_5.setOnClickListener { pet = Pet(5,30,"here5")}
        choise_6.setOnClickListener { pet = Pet(6,10,"here6") }



        choise_decide_button.setOnClickListener {
            var intent = Intent(this,menu::class.java)
            pet.pet_name = choise_name_text.text.toString()
            intent.putExtra("pet",pet)
            startActivity(intent)
        }
    }



}
