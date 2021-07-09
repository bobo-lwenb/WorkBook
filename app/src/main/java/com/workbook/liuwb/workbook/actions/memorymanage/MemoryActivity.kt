package com.workbook.liuwb.workbook.actions.memorymanage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.memorymanage.anr.ANRActivity
import com.workbook.liuwb.workbook.actions.memorymanage.memoryleak.MemoryLeakActivity
import com.workbook.liuwb.workbook.databinding.ActivityMemoryBinding

class MemoryActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityMemoryBinding by lazy {
        ActivityMemoryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.memoryLeak.setOnClickListener(this)
        binding.anr.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.memory_leak -> {
                intent = Intent(this, MemoryLeakActivity::class.java)
                startActivity(intent)
            }
            R.id.anr -> {
                intent = Intent(this, ANRActivity::class.java)
                startActivity(intent)
            }
        }
    }
}