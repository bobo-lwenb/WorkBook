package com.workbook.liuwb.workbook.aboutview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.aboutview.customview.CustomImageActivity
import com.workbook.liuwb.workbook.aboutview.customview.CustomProgressBarActivity
import com.workbook.liuwb.workbook.aboutview.customview.CustomTitleActivity
import com.workbook.liuwb.workbook.aboutview.customviewgroup.cornerviewgroup.CustomContainerActivity
import com.workbook.liuwb.workbook.aboutview.customviewgroup.cornerviewgroup.FlowLayoutActivity
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
        viewmain_customtitle.setOnClickListener(this)
        viewmain_customtimage.setOnClickListener(this)
        viewmain_CustomProgressBar.setOnClickListener(this)
        viewmain_CustomContainer.setOnClickListener(this)
        viewmain_FlowLayout.setOnClickListener(this)
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
            R.id.viewmain_customtitle -> {
                intent.setClass(this@ViewMainActivity, CustomTitleActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_customtimage -> {
                intent.setClass(this@ViewMainActivity, CustomImageActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_CustomProgressBar -> {
                intent.setClass(this@ViewMainActivity, CustomProgressBarActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_CustomContainer -> {
                intent.setClass(this@ViewMainActivity, CustomContainerActivity::class.java)
                startActivity(intent)
            }
            R.id.viewmain_FlowLayout -> {
                intent.setClass(this@ViewMainActivity, FlowLayoutActivity::class.java)
                startActivity(intent)
            }

            else -> {

            }
        }
    }
}