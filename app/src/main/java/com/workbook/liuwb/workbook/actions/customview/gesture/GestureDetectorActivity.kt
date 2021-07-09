package com.workbook.liuwb.workbook.actions.customview.gesture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityGesturedetectorBinding

class GestureDetectorActivity : AppCompatActivity() {

    private val binding: ActivityGesturedetectorBinding by lazy {
        ActivityGesturedetectorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}