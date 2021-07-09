package com.workbook.liuwb.workbook.actions.third

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.third.glide.GlideActivity
import com.workbook.liuwb.workbook.actions.third.retrofit.RetrofitActivity
import com.workbook.liuwb.workbook.databinding.ActivityThirdMainBinding

class ThirdMainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityThirdMainBinding by lazy {
        ActivityThirdMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.glide.setOnClickListener(this)
        binding.retrofit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.glide -> {
                intent = Intent(this, GlideActivity::class.java)
                startActivity(intent)
            }
            R.id.retrofit -> {
                intent = Intent(this, RetrofitActivity::class.java)
                startActivity(intent)
            }
        }
    }
}