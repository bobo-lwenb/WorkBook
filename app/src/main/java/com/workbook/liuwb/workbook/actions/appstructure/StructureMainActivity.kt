package com.workbook.liuwb.workbook.actions.appstructure

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityStructureMainBinding
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.view.UserActivity
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.UserLoginActivity

class StructureMainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityStructureMainBinding by lazy {
        ActivityStructureMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mvpV1.setOnClickListener(this)
        binding.mvpV2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when(v.id) {
            R.id.mvp_v1 -> {
                intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            R.id.mvp_v2 -> {
                intent = Intent(this, UserLoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}