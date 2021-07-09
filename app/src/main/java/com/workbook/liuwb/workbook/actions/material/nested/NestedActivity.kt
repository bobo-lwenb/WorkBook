package com.workbook.liuwb.workbook.actions.material.nested

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityNestedBinding

class NestedActivity : AppCompatActivity() {

    private val binding: ActivityNestedBinding by lazy {
        ActivityNestedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}