package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityCustomcontainerBinding

class CustomContainerActivity : AppCompatActivity() {

    private val binding: ActivityCustomcontainerBinding by lazy {
        ActivityCustomcontainerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}