package com.workbook.liuwb.workbook.actions.viewdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.viewdemo.menu.MenuDemoActivity
import com.workbook.liuwb.workbook.actions.viewdemo.scrollable.ScrollableActivity
import com.workbook.liuwb.workbook.databinding.ActivityViewDemoBinding
import com.workbook.liuwb.workbook.actions.viewdemo.notification.NotificationDemoActivity

class ViewDemoActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityViewDemoBinding by lazy {
        ActivityViewDemoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.scrollable.setOnClickListener(this)
        binding.menu.setOnClickListener(this)
        binding.notification.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.scrollable -> {
                intent = Intent(this, ScrollableActivity::class.java)
                startActivity(intent)
            }
            R.id.menu -> {
                intent = Intent(this, MenuDemoActivity::class.java)
                startActivity(intent)
            }
            R.id.notification -> {
                intent = Intent(this, NotificationDemoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}