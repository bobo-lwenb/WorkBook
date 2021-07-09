package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityMyScrollerBinding

class MyScrollerActivity : AppCompatActivity() {

    private val binding: ActivityMyScrollerBinding by lazy {
        ActivityMyScrollerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}