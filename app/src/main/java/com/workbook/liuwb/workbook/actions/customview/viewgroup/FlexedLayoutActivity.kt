package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityFlexedLayoutBinding

class FlexedLayoutActivity : AppCompatActivity() {

    private val binding: ActivityFlexedLayoutBinding by lazy {
        ActivityFlexedLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}