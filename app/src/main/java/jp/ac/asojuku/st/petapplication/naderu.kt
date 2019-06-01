package jp.ac.asojuku.st.petapplication

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class naderu : AppCompatActivity(), SensorEventListener {
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_naderu)

        val flickView = window.decorView // Activity画面
        val adjustX = 150.0f
        val adjustY = 150.0f

        object : FlickCheck(flickView, adjustX, adjustY) {

            override fun getFlick(flickData: Int) {
                ////////
                //撫でた時の処理
                ////////
            }
        }

    }
}
