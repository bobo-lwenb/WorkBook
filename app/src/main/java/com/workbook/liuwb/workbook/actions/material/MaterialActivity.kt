package com.workbook.liuwb.workbook.actions.material

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityMaterialBinding
import com.workbook.liuwb.workbook.actions.material.nested.NestedActivity

class MaterialActivity : AppCompatActivity() {

    private val binding: ActivityMaterialBinding by lazy {
        ActivityMaterialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.collapsing.setOnClickListener {
            val intent = Intent(this, CollapsingActivity::class.java)
            startActivity(intent)
        }

        binding.floating.setOnClickListener {
            val intent = Intent(this, ScrollFlagsActivity::class.java)
            startActivity(intent)
        }

        binding.nested.setOnClickListener {
            val intent = Intent(this, NestedActivity::class.java)
            startActivity(intent)
        }
    }
}