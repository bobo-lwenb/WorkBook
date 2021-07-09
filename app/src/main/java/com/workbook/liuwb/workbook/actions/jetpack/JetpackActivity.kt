package com.workbook.liuwb.workbook.actions.jetpack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.jetpack.databind.DataBindDemoActivity
import com.workbook.liuwb.workbook.databinding.ActivityJetpackBinding

class JetpackActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityJetpackBinding by lazy {
        ActivityJetpackBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.databinding.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.databinding -> {
                intent = Intent(this, DataBindDemoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}