package jp.ac.asojuku.st.petapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class water : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)
        var tick = 0;
        val thread = Thread(Runnable {
            try {
                while (tick<5) {
                    Thread.sleep(1000)
                    if(tick%2==0){
                        Log.d("1","1")
                        ///////画像を表示
                    }else{
                        Log.d("2","2")
                        ///////画像を表示
                    }
                    tick ++

                }
                val intent = Intent(this, menu::class.java)
                startActivity(intent)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })
        thread.start()

    }
}
