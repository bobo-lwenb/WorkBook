package com.workbook.liuwb.workbook.material

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.material.nested.NestedActivity
import kotlinx.android.synthetic.main.activity_material.*

class MaterialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)

        collapsing.setOnClickListener { v ->
            val intent = Intent(this@MaterialActivity, CollapsingActivity::class.java)
            startActivity(intent)
        }

        float_.setOnClickListener { v ->
            val intent = Intent(this@MaterialActivity, ScrollFlagsActivity::class.java)
            startActivity(intent)
        }

        nested.setOnClickListener { v ->
            val intent = Intent(this@MaterialActivity, NestedActivity::class.java)
            startActivity(intent)
        }
    }
}