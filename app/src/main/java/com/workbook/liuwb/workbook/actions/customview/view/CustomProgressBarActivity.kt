package com.workbook.liuwb.workbook.actions.customview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityCustomprogressbarBinding

class CustomProgressBarActivity : AppCompatActivity() {

    private val binding: ActivityCustomprogressbarBinding by lazy {
        ActivityCustomprogressbarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}