package com.workbook.liuwb.workbook.aboutview.customviewgroup.carousel

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.views.FollowFingerView

class CarouselActivity : AppCompatActivity() {

    private var carousel: CarouselViewGroup? = null
    private var followFingerView: FollowFingerView? = null

    private val ids = intArrayOf(Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)
        carousel = findViewById(R.id.carouselvg)
        followFingerView = findViewById(R.id.followFingerView)

        followFingerView!!.setOnClickListener { Logger.e("FollowFingerView==========") }

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        for (i in ids.indices) {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.CENTER_CROP
            iv.layoutParams = ViewGroup.LayoutParams(width, height / 4)
            iv.setBackgroundColor(ids[i])
            carousel!!.addView(iv)
        }
    }
}
