package com.workbook.liuwb.workbook.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_launch_main.*

class LaunchMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_main)

        Logger.e("LaunchMainActivity taskId = $taskId")

        launchmain_one.setOnClickListener { v ->
            val intent = Intent(this@LaunchMainActivity, LaunchOneActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_MULTIPLE_TASK
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_DOCUMENT
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.flags = Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS
//            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            startActivity(intent)
        }
    }
}