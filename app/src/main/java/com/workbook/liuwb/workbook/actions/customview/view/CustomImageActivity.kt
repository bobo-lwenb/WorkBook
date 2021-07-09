package com.workbook.liuwb.workbook.actions.customview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityCustomimageBinding

class CustomImageActivity : AppCompatActivity() {

    private val binding: ActivityCustomimageBinding by lazy {
        ActivityCustomimageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}