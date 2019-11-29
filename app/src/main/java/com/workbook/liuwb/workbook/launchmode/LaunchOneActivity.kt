package com.workbook.liuwb.workbook.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_launch_one.*

class LaunchOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_one)

        Logger.e("LaunchOneActivity taskId = $taskId")

        launchone_one.setOnClickListener { v ->
            val intent = Intent(this@LaunchOneActivity, LaunchTwoActivity::class.java)
            startActivity(intent)
        }
    }
}