package com.workbook.liuwb.workbook.aboutview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.aboutview.gesturedetector.GestureDetectorActivity
import com.workbook.liuwb.workbook.aboutview.scroller.ScrollToByActivity
import com.workbook.liuwb.workbook.aboutview.velocitytracker.VelocityTrackerActivity
import kotlinx.android.synthetic.main.activity_view_main.*

class ViewMainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_main)

        viewmain_velocitytracker.setOnClickListener(this)
        viewmain_gesturedetector.setOnClickListener(this)
        viewmain_scrolltoby.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent = Intent()
        when (view?.id) {
            R.id.viewmain_velocitytracker -> {
                intent.setClass(this@ViewMainActivity, VelocityTrackerActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_gesturedetector -> {
                intent.setClass(this@ViewMainActivity, GestureDetectorActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_scrolltoby -> {
                intent.setClass(this@ViewMainActivity, ScrollToByActivity::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }
}