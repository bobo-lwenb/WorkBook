package com.workbook.liuwb.workbook.service.bind.binder

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R

class BindingActivity : AppCompatActivity() {
    private lateinit var mService: LocalService
    private var mBound: Boolean = false

    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(componentName: ComponentName?) {
            mBound = false
        }

        override fun onServiceConnected(componentName: ComponentName?, service: IBinder?) {
            val binder = service as LocalService.LocalBinder
            mService = binder.getService()
            mBound = true
        }
    }

    override fun onStart() {
        super.onStart()
        // Bind to LocalService
        Intent(this, LocalService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding)
    }

    override fun onStop() {
        super.onStop()
        if (mBound) {
            unbindService(connection)
            mBound = false
        }
    }

    fun onButtonClick(v: View) {
        if (mBound) {
            // Call a method from the LocalService.
            // However, if this call were something that might hang, then this request should
            // occur in a separate thread to avoid slowing down the activity performance.
            val num: Int = mService.randomNumber
            Toast.makeText(this, "number is $num", Toast.LENGTH_LONG).show()
        }
    }
}