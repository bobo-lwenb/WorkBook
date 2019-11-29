package com.workbook.liuwb.workbook.aboutview.scroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_scrolltoby.*

class ScrollToByActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolltoby)

        val view = findViewById<Button>(R.id.tb_view)

        tb_scroll.setOnClickListener {
            Logger.e("ScrollToByActivity: ${tb_layour.scrollX} ${tb_layour.scrollX}")
            tb_layour.scrollTo(5, 5)
        }

        tb_layour.setOnClickListener {
            Logger.e("ScrollToByActivity: ${tb_layour.scrollX} ${tb_layour.scrollX}")
            tb_layour.scrollBy(-5, -5)
        }
    }
}