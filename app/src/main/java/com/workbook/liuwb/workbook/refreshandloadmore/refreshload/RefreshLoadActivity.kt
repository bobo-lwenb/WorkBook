package com.workbook.liuwb.workbook.refreshandloadmore.refreshload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_refresh_load.*

class RefreshLoadActivity : AppCompatActivity() {

    private val datas = listOf("11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11", "11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refresh_load)

        val rlAdapter = RLAdapter(this, datas)
        rl_listview.adapter = rlAdapter
    }
}