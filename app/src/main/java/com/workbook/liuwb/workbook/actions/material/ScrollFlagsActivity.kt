package com.workbook.liuwb.workbook.actions.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityScrollFlagsBinding

class ScrollFlagsActivity : AppCompatActivity() {

    private val binding: ActivityScrollFlagsBinding by lazy {
        ActivityScrollFlagsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_flags)

        setSupportActionBar(binding.toolbarFlag)
        binding.fabFlag.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}