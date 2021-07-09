package com.workbook.liuwb.workbook.actions.memorymanage.anr

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityAnrBinding

class ANRActivity : AppCompatActivity() {

    private val binding: ActivityAnrBinding by lazy {
        ActivityAnrBinding.inflate(layoutInflater)
    }
    private val receiver: MyReceiver by lazy {
        MyReceiver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentFilter = IntentFilter(ACTION_FIRST)
        registerReceiver(receiver, intentFilter)

        binding.btnSendGlobalBroadcast.setOnClickListener {
            sendGlobalBroadcast()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    private fun sendGlobalBroadcast() {
        val intent = Intent()
        intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND)
        intent.action = ACTION_FIRST
        sendBroadcast(intent)
    }

    companion object {
        private const val ACTION_FIRST = "com.brotherd.broadcastdemo.BROADCAST_FIRST"
    }
}