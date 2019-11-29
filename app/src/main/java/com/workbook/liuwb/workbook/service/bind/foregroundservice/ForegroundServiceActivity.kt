package com.workbook.liuwb.workbook.service.bind.foregroundservice

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R

class ForegroundServiceActivity : AppCompatActivity() {

    private val intent1: Intent = Intent(this, MyService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foregroundservice)
    }

    fun onStartService(v: View) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForegroundService(intent1)
//        } else {
            startService(intent1)
//        }
    }

    fun onStopService(v: View) {
        stopService(intent1)
    }
}