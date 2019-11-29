package com.workbook.liuwb.workbook.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_launch_two.*

class LaunchTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_two)

        Logger.e("LaunchTwoActivity taskId = $taskId")

        launchtwo_one.setOnClickListener { v ->
            val intent = Intent(this@LaunchTwoActivity, LaunchThreeActivity::class.java)
            startActivity(intent)
        }
    }
}