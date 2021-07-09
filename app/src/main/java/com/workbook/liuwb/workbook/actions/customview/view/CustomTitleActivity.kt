package com.workbook.liuwb.workbook.actions.customview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityCustomtitleBinding

class CustomTitleActivity : AppCompatActivity() {
    private val binding: ActivityCustomtitleBinding by lazy {
        ActivityCustomtitleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}