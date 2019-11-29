package com.workbook.liuwb.workbook.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_scroll_flags.*

class ScrollFlagsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_flags)

        val toolbar = toolbar_flag
        val fab = fab_flag

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}