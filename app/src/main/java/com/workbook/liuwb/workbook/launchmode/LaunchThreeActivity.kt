package com.workbook.liuwb.workbook.launchmode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_launch_three.*

class LaunchThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_three)

        Logger.e("LaunchThreeActivity taskId = $taskId")

        launchthree_one.setOnClickListener { v ->
            val intent = Intent(this@LaunchThreeActivity, LaunchOneActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}