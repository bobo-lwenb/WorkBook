package com.workbook.liuwb.workbook.actions.viewdemo.scrollable

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.viewdemo.scrollable.listview.ListViewActivity
import com.workbook.liuwb.workbook.actions.viewdemo.scrollable.recyclerview.RecycleActivity
import com.workbook.liuwb.workbook.databinding.ActivityScrollableBinding

class ScrollableActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityScrollableBinding by lazy {
        ActivityScrollableBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.listview -> {
                intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            R.id.recyclerview -> {
                intent = Intent(this, RecycleActivity::class.java)
                startActivity(intent)
            }
        }
    }
}