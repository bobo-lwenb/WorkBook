package com.workbook.liuwb.workbook.actions.webview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityWebviewBinding by lazy {
        ActivityWebviewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.androidToJs.setOnClickListener(this)
        binding.jsToAndroid.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.android_to_js -> {
                intent = Intent(this, Android2JSActivity::class.java)
                startActivity(intent)
            }
            R.id.js_to_android -> {
                intent = Intent(this, JS2AndroidActivity::class.java)
                startActivity(intent)
            }
        }
    }
}