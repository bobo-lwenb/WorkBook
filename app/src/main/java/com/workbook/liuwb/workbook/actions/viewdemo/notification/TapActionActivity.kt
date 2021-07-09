package com.workbook.liuwb.workbook.actions.viewdemo.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityTapActionBinding

class TapActionActivity : AppCompatActivity() {

    private val binding: ActivityTapActionBinding by lazy {
        ActivityTapActionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (intent.hasExtra("data")) {
            val text = intent.getStringExtra("data")
            binding.tapText.text = text
        }
    }
}