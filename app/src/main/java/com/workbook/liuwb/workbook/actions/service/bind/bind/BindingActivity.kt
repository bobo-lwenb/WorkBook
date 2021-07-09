package com.workbook.liuwb.workbook.actions.service.bind.bind

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    private val binding: ActivityBindingBinding by lazy {
        ActivityBindingBinding.inflate(layoutInflater)
    }

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
        setContentView(binding.root)
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