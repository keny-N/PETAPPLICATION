package jp.ac.asojuku.st.petapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*
import android.widget.*


class menu : AppCompatActivity() {

    var hp = 0   //体力変数
    var love = 0 //愛情変数
    var pet = Pet(0,0,"")
    var flg = true

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val extras = intent.extras
        pet = extras!!.getSerializable("pet") as Pet
        this.hp = pet.pet_water/17
        this.love = pet.pet_love/17
        setWater()
        setLove()
        petName.setText(pet.pet_name)

        val handler = Handler()
        var thread = Thread(Runnable {
            while (flg == true) {
                Thread.sleep(1000)
                pet.tick()
                if(pet.pet_love/20 != love){
                    this.love = pet.pet_love/17

                    handler.post { setLove() }
                }
                if (pet.pet_water < 0) {
                    hp = 0
                    handler.post{setWater()}
                    flg = false
                    var intent = Intent(this,end::class.java)
                    if(pet.pet_love>=100){
                        intent.putExtra("flg",1)
                    }else{
                        intent.putExtra("flg",0)
                    }
                    intent.putExtra("pet",pet)
                    startActivity(intent)
                } else if (hp != pet.pet_water / 17) {
                    hp = pet.pet_water/17
                    handler.post {
                        setWater()
                    }
                }
                Log.d("e", pet.pet_water.toString())
            }
        })
        thread.start()
        val data = ArrayList<String>()
        data.add("ふる")
        data.add("なでる")
        data.add("？？？")
        data.add("？？？")
        data.add("？？？")
        data.add("CommingSoon")
        data.add("CommingSoon")
        val data2 = ArrayList<String>()
        data2.add("みずをあげる")
        data2.add("？？？")
        data2.add("？？？")
        data2.add("CommingSoon")


        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data2)

        // ListViewにArrayAdapterを設定する
        val listView = findViewById(R.id.listView) as ListView
        val listView2 = findViewById(R.id.listView2) as ListView

        listView.setAdapter(adapter)
        listView.setVisibility(View.INVISIBLE)
        listView2.setAdapter(adapter2)
        listView2.setVisibility(View.INVISIBLE)

        listView.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> {
                    flg = false
                    var intent = Intent(this, shake::class.java)
                    intent.putExtra("pet",pet)
                    startActivity(intent)
                }
                1 -> {
                    flg = false
                    var intent = Intent(this, naderu::class.java)
                    intent.putExtra("pet",pet)
                    startActivity(intent)
                }
            }
        }
        listView2.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> {
                    flg = false
                    var intent = Intent(this, water::class.java)
                    intent.putExtra("pet",pet)
                    startActivity(intent)
                }
            }
        }

    }


    override fun onResume() {
        super.onResume()
//        var asobi_button = findViewById<Button>(R.id.asobi_button) as Button
//        var naderu_button = findViewById<Button>(R.id.naderu_button) as Button
//        var water_button = findViewById<Button>(R.id.water_button) as Button
//        var test_button = findViewById<Button>(R.id.testbutton) as Button
//        var test2_button = findViewById<Button>(R.id.testbutton2) as Button



        var listv = false
        var list2v = false
        abutton.setOnClickListener {
            if(list2v == true) {
                listView2.setVisibility(View.INVISIBLE)
                listView.setVisibility(View.VISIBLE)
                list2v = false
                listv = true
            }else if(listv == true){
                listView.setVisibility(View.INVISIBLE)
                listv = false
            }else{
                listView.setVisibility(View.VISIBLE)
                listv = true
            }
        }
        abutton2.setOnClickListener {
            if(listv == true) {
                listView.setVisibility(View.INVISIBLE)
                listView2.setVisibility(View.VISIBLE)
                listv = false
                list2v = true
            }else if(list2v == true){
                listView2.setVisibility(View.INVISIBLE)
                list2v = false
            }else{
                listView2.setVisibility(View.VISIBLE)
                list2v = true
            }
        }


//        asobi_button.setOnClickListener {
//            flg = false
//            var intent = Intent(this, shake::class.java)
//            intent.putExtra("pet",pet)
//            startActivity(intent)
//        }
//
//        naderu_button.setOnClickListener {
//            flg = false
//            var intent = Intent(this, naderu::class.java)
//            intent.putExtra("pet",pet)
//            startActivity(intent)
//        }
//        water_button.setOnClickListener {
//            flg = false
//            var intent = Intent(this, water::class.java)
//            intent.putExtra("pet",pet)
//            startActivity(intent)
//        }
    }
    fun setWater() {
        when (hp) {
            0 -> {
                hp_icon_1.setImageResource(R.drawable.hp_x)
                hp_icon_2.setImageResource(R.drawable.hp_x)
                hp_icon_3.setImageResource(R.drawable.hp_x)
                hp_icon_4.setImageResource(R.drawable.hp_x)
            }
            1 -> {
                hp_icon_1.setImageResource(R.drawable.hp)
                hp_icon_2.setImageResource(R.drawable.hp_x)
                hp_icon_3.setImageResource(R.drawable.hp_x)
                hp_icon_4.setImageResource(R.drawable.hp_x)

            }
            2 -> {
                hp_icon_1.setImageResource(R.drawable.hp)
                hp_icon_2.setImageResource(R.drawable.hp)
                hp_icon_3.setImageResource(R.drawable.hp_x)
                hp_icon_4.setImageResource(R.drawable.hp_x)

            }
            3 -> {
                hp_icon_1.setImageResource(R.drawable.hp)
                hp_icon_2.setImageResource(R.drawable.hp)
                hp_icon_3.setImageResource(R.drawable.hp)
                hp_icon_4.setImageResource(R.drawable.hp_x)

            }
            4 -> {
                hp_icon_1.setImageResource(R.drawable.hp)
                hp_icon_2.setImageResource(R.drawable.hp)
                hp_icon_3.setImageResource(R.drawable.hp)
                hp_icon_4.setImageResource(R.drawable.hp)

            }

        }
    }
    fun setLove() {
        var love1 = findViewById<ImageView>(R.id.love_icon_1)
        var love2 = findViewById<ImageView>(R.id.love_icon_2)
        var love3 = findViewById<ImageView>(R.id.love_icon_3)
        var love4 = findViewById<ImageView>(R.id.love_icon_4)
        when (love) {
            0 -> {
                love_icon_1.setImageResource(R.drawable.love_x)
                love_icon_2.setImageResource(R.drawable.love_x)
                love_icon_3.setImageResource(R.drawable.love_x)
                love_icon_4.setImageResource(R.drawable.love_x)
            }
            1 -> {
                love_icon_1.setImageResource(R.drawable.love)
                love_icon_2.setImageResource(R.drawable.love_x)
                love_icon_3.setImageResource(R.drawable.love_x)
                love_icon_4.setImageResource(R.drawable.love_x)

            }
            2 -> {
                love_icon_1.setImageResource(R.drawable.love)
                love_icon_2.setImageResource(R.drawable.love)
                love_icon_3.setImageResource(R.drawable.love_x)
                love_icon_4.setImageResource(R.drawable.love_x)

            }
            3 -> {
                love_icon_1.setImageResource(R.drawable.love)
                love_icon_2.setImageResource(R.drawable.love)
                love_icon_3.setImageResource(R.drawable.love)
                love_icon_4.setImageResource(R.drawable.love_x)

            }
            4 -> {
                love_icon_1.setImageResource(R.drawable.love)
                love_icon_2.setImageResource(R.drawable.love)
                love_icon_3.setImageResource(R.drawable.love)
                love_icon_4.setImageResource(R.drawable.love)

            }

        }
    }
}
