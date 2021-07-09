package com.workbook.liuwb.workbook.actions.function

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.function.aidl.BookManagerActivity
import com.workbook.liuwb.workbook.actions.function.permission.PermissionActivity
import com.workbook.liuwb.workbook.actions.function.annotation.AnnoActivity
import com.workbook.liuwb.workbook.actions.function.reflect.ReflectActivity
import com.workbook.liuwb.workbook.databinding.ActivityFuntionMainBinding
import com.workbook.liuwb.workbook.actions.function.file.FliesListActivity

class FunctionMainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityFuntionMainBinding by lazy {
        ActivityFuntionMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.permission.setOnClickListener(this)
        binding.aidl.setOnClickListener(this)
        binding.javaAnnotation.setOnClickListener(this)
        binding.javaReflect.setOnClickListener(this)
        binding.fileProvider.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.permission -> {
                intent = Intent(this, PermissionActivity::class.java)
                startActivity(intent)
            }
            R.id.aidl -> {
                intent = Intent(this, BookManagerActivity::class.java)
                startActivity(intent)
            }
            R.id.java_annotation -> {
                intent = Intent(this, AnnoActivity::class.java)
                startActivity(intent)
            }
            R.id.java_reflect -> {
                intent = Intent(this, ReflectActivity::class.java)
                startActivity(intent)
            }
            R.id.file_provider -> {
                intent = Intent(this, FliesListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}