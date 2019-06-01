package jp.ac.asojuku.st.petapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {

    var hp =2   //体力変数
    var love =3 //愛情変数

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        intent.getIntExtra("dec",0)
        intent.getIntExtra("border",0)
        intent.getStringExtra("png")
        intent.getStringExtra("name")

        Log.d("TEST", intent.getStringExtra("name").toString())

        petName.setText(intent.getStringExtra("name"))


    }

    override fun onResume() {
        super.onResume()
        var asobi_button = findViewById<Button>(R.id.asobi_button) as Button
        var naderu_button = findViewById<Button>(R.id.naderu_button) as Button
        var water_button = findViewById<Button>(R.id.water_button) as Button
        var test_button = findViewById<Button>(R.id.testbutton) as Button
        var test2_button = findViewById<Button>(R.id.testbutton2) as Button



        var hp1 = findViewById<ImageView>(R.id.hp_icon_1)
        var hp2 = findViewById<ImageView>(R.id.hp_icon_2)
        var hp3 = findViewById<ImageView>(R.id.hp_icon_3)
        var hp4 = findViewById<ImageView>(R.id.hp_icon_4)
        var love1 = findViewById<ImageView>(R.id.love_icon_1)
        var love2 = findViewById<ImageView>(R.id.love_icon_2)
        var love3 = findViewById<ImageView>(R.id.love_icon_3)
        var love4 = findViewById<ImageView>(R.id.love_icon_4)

        asobi_button.setOnClickListener {
            var intent = Intent(this,shake::class.java)

            startActivity(intent)
        }

        naderu_button.setOnClickListener {
            var intent = Intent(this,naderu::class.java)

            startActivity(intent)
        }
        water_button.setOnClickListener {
            var intent = Intent(this,water::class.java)

            startActivity(intent)
        }


        when(hp){
            0 ->{   hp1.setImageResource(R.drawable.hp_x)
                    hp2.setImageResource(R.drawable.hp_x)
                    hp3.setImageResource(R.drawable.hp_x)
                    hp4.setImageResource(R.drawable.hp_x)
            }
            1 ->{
                hp1.setImageResource(R.drawable.hp)
                hp2.setImageResource(R.drawable.hp_x)
                hp3.setImageResource(R.drawable.hp_x)
                hp4.setImageResource(R.drawable.hp_x)

            }
            2 ->{
                hp1.setImageResource(R.drawable.hp)
                hp2.setImageResource(R.drawable.hp)
                hp3.setImageResource(R.drawable.hp_x)
                hp4.setImageResource(R.drawable.hp_x)

            }
            3 ->{
                hp1.setImageResource(R.drawable.hp)
                hp2.setImageResource(R.drawable.hp)
                hp3.setImageResource(R.drawable.hp)
                hp4.setImageResource(R.drawable.hp_x)

            }
            4 ->{
                hp1.setImageResource(R.drawable.hp)
                hp2.setImageResource(R.drawable.hp)
                hp3.setImageResource(R.drawable.hp)
                hp4.setImageResource(R.drawable.hp)

            }

        }
        when(love){
            0 ->{
                love1.setImageResource(R.drawable.love_x)
                love2.setImageResource(R.drawable.love_x)
                love3.setImageResource(R.drawable.love_x)
                love4.setImageResource(R.drawable.love_x)
            }
            1 ->{
                love1.setImageResource(R.drawable.love)
                love2.setImageResource(R.drawable.love_x)
                love3.setImageResource(R.drawable.love_x)
                love4.setImageResource(R.drawable.love_x)

            }
            2 ->{
                love1.setImageResource(R.drawable.love)
                love2.setImageResource(R.drawable.love)
                love3.setImageResource(R.drawable.love_x)
                love4.setImageResource(R.drawable.love_x)

            }
            3 ->{
                love1.setImageResource(R.drawable.love)
                love2.setImageResource(R.drawable.love)
                love3.setImageResource(R.drawable.love)
                love4.setImageResource(R.drawable.love_x)

            }
            4 ->{
                love1.setImageResource(R.drawable.love)
                love2.setImageResource(R.drawable.love)
                love3.setImageResource(R.drawable.love)
                love4.setImageResource(R.drawable.love)

            }

        }





    }
}
