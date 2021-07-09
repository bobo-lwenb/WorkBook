package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityCarouselBinding

class CarouselActivity : AppCompatActivity() {

    private val ids = intArrayOf(Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN)

    private val binding: ActivityCarouselBinding by lazy {
        ActivityCarouselBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        for (i in ids.indices) {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.CENTER_CROP
            iv.layoutParams = ViewGroup.LayoutParams(width, height / 4)
            iv.setBackgroundColor(ids[i])
            binding.carouselvg.addView(iv)
        }
    }
}
