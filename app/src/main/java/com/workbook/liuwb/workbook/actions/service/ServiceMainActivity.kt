package com.workbook.liuwb.workbook.actions.service

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.service.bind.bind.BindingActivity
import com.workbook.liuwb.workbook.actions.service.bind.messenger.MessengerActivity
import com.workbook.liuwb.workbook.actions.service.bind.messengerdemo.ActivityMessenger
import com.workbook.liuwb.workbook.actions.service.start.foregroundservice.ForegroundServiceActivity
import com.workbook.liuwb.workbook.databinding.ActivityServiceMainBinding

class ServiceMainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityServiceMainBinding by lazy {
        ActivityServiceMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startService.setOnClickListener(this)
        binding.foregroundService.setOnClickListener(this)
        binding.bindService.setOnClickListener(this)
        binding.messengerSingle.setOnClickListener(this)
        binding.messengerBoth.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.start_service -> {
            }
            R.id.foreground_service -> {
                intent = Intent(this, ForegroundServiceActivity::class.java)
                startActivity(intent)
            }
            R.id.bind_service -> {
                intent = Intent(this, BindingActivity::class.java)
                startActivity(intent)
            }
            R.id.messenger_single -> {
                intent = Intent(this, ActivityMessenger::class.java)
                startActivity(intent)
            }
            R.id.messenger_both -> {
                intent = Intent(this, MessengerActivity::class.java)
                startActivity(intent)
            }
        }
    }
}