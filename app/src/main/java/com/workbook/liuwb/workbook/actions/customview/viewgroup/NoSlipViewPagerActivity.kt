package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityNoSlipViewpagerBinding

class NoSlipViewPagerActivity : AppCompatActivity() {

    private val binding: ActivityNoSlipViewpagerBinding by lazy {
        ActivityNoSlipViewpagerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}