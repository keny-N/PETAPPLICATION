package jp.ac.asojuku.st.petapplication

import android.util.Log
import android.view.MotionEvent
import android.view.View

abstract class FlickCheck
/**
 * frickViewにはフリックを検知させるViewをセット<br></br>
 * adjustXには左右のフリック距離目安、adjustYには上下のフリック距離目安をセット
 * @param frickView
 * @param adjustX
 * @param adjustY
 */
    (frickView: View, adjustX: Float, adjustY: Float) {

    private var adjustX = 150.0f
    private var adjustY = 150.0f
    private var touchX: Float = 0.toFloat()
    private var touchY: Float = 0.toFloat()

    private var maxY: Float = 0.toFloat()
    private var minY: Float = 0.toFloat()
    private var maxX: Float = 0.toFloat()
    private var minX: Float = 0.toFloat()

    private var turn:Int = 0

    private var prefTouchX: Float = 0.toFloat()
    private var prefTouchY: Float = 0.toFloat()
    private var pref2TouchX: Float = 0.toFloat()
    private var pref2TouchY: Float = 0.toFloat()

    init {

        this.adjustX = adjustX
        this.adjustY = adjustY

        frickView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("result" , "te")
                    touchX = event.x
                    touchY = event.y
                    maxX = event.x
                    minX = event.x
                    maxY = event.y
                    minY = event.y
                    turn = 0
                    pref2TouchX = event.x
                    prefTouchX = event.x
                    pref2TouchY = event.y
                    prefTouchX = event.y

                }
                MotionEvent.ACTION_UP -> {
//                    nowTouchX = event.x
//                    nowTouchY = event.y
                    check()
                    v.performClick()
                }
                MotionEvent.ACTION_MOVE -> {
                    if(event.x>maxX) maxX = event.x
                    if(event.x<minX) minX = event.x
                    if(event.y>maxY) maxY = event.y
                    if(event.y<minY) maxY = event.y

                    if(pref2TouchX>prefTouchX && prefTouchX<event.x){
                        turn++
                    }else if(pref2TouchX<prefTouchX && prefTouchX>event.x){
                        turn++
                    }else if(pref2TouchY>prefTouchY && prefTouchY<event.y){
                        turn++
                    }else if(pref2TouchY<prefTouchY && prefTouchY>event.y) {
                        turn++
                    }

                    pref2TouchX = prefTouchX
                    pref2TouchY = prefTouchY
                    prefTouchX = event.x
                    prefTouchY = event.y
                }
                MotionEvent.ACTION_CANCEL -> {
                }
            }
            true
        }
    }

    /**
     * どの方向にフリックしたかチェック
     */
    private fun check() {

        if(turn>1){
            Log.d("result" , turn.toString())
            getFlick(turn)
            return
        }
    }

    /**
     * 抽象メソッド：フリックを感知した際、方向を表す値をセットする
     * @param swipe
     */
    abstract fun getFlick(swipe: Int)


}

