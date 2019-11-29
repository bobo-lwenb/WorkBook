package com.workbook.liuwb.workbook.refreshandloadmore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.refreshandloadmore.refreshload.RefreshLoadActivity
import kotlinx.android.synthetic.main.activity_main_refresh_load.*

class RefreshLoadMainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_refresh_load)

        list_refresh_load.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = when (v?.id) {
            R.id.list_refresh_load -> Intent(this@RefreshLoadMainActivity, RefreshLoadActivity::class.java)
            else -> Intent()
        }
        startActivity(intent)
    }

}