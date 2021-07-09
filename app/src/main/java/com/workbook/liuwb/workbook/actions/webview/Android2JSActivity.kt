package com.workbook.liuwb.workbook.actions.webview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityAndroid2jsBinding

class Android2JSActivity : AppCompatActivity() {

    private val binding: ActivityAndroid2jsBinding by lazy {
        ActivityAndroid2jsBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val webSettings: WebSettings = binding.jsWebview.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        binding.jsWebview.loadUrl("file:///android_asset/android2js.html")
        binding.jsWebview.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this@Android2JSActivity)
                builder.setTitle("alert")
                builder.setMessage(message)
                builder.setPositiveButton("Ok") { _, _ ->
                    result!!.confirm()
                }
                builder.setCancelable(false)
                builder.create().show()
                return true
            }
        }

        binding.loadUrl.setOnClickListener {
            // 1、webview.loadUrl()方法
            binding.jsWebview.post { binding.jsWebview.loadUrl("javascript:callJS()") }
        }

        binding.evaluateJavascript.setOnClickListener {
            // 1、webview.evaluateJavascript()方法
            binding.jsWebview.evaluateJavascript("javascript:callJS()") {
                println("evaluateJavascript: $it")
            }
        }

    }
}