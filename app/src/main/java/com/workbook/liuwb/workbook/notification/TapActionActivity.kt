package com.workbook.liuwb.workbook.notification

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_tap_action.*

class TapActionActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tap_action)

        textView = tap_text

        val intent = intent
        if (intent.hasExtra("data")) {
            val text = intent.getStringExtra("data")
            textView?.text = text
        }
    }
}