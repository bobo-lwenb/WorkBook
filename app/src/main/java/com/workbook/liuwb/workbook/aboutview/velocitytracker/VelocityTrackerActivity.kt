package com.workbook.liuwb.workbook.aboutview.velocitytracker

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.widget.OverScroller
import android.widget.Scroller
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R

class VelocityTrackerActivity : AppCompatActivity() {

    private val velocityTracker by lazy {
        VelocityTracker.obtain()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_velocity_tracker)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {

            }
            MotionEvent.ACTION_MOVE -> {
                velocityTracker.addMovement(event)
            }
            MotionEvent.ACTION_UP -> {
                velocityTracker.computeCurrentVelocity(1000)
                val velocityX = velocityTracker.xVelocity
                val velocityY = velocityTracker.yVelocity
                Logger.e("VelocityTrackerActivity: $velocityX   $velocityY")
            }
            MotionEvent.ACTION_CANCEL -> {
                velocityTracker.clear()
                velocityTracker.recycle()
            }
            else -> {

            }
        }
        return super.onTouchEvent(event)
    }
}