package com.workbook.liuwb.workbook.actions.customview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.databinding.ActivityFollowFingerBinding

class FollowFingerActivity : AppCompatActivity() {

    private val binding: ActivityFollowFingerBinding by lazy {
        ActivityFollowFingerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.followFinger.setOnClickListener { Logger.e("FollowFingerView==========") }
    }
}