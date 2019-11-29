package com.workbook.liuwb.workbook.webview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_android2js.*

class Android2JSActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android2js)

        val webSettings: WebSettings = js_webview.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        js_webview.loadUrl("file:///android_asset/android2js.html")
        js_webview.webChromeClient = object : WebChromeClient() {
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

        loadUrl.setOnClickListener {
            // 1、webview.loadUrl()方法
            js_webview.post { js_webview.loadUrl("javascript:callJS()") }
        }

        evaluateJavascript.setOnClickListener {
            // 1、webview.evaluateJavascript()方法
            js_webview.evaluateJavascript("javascript:callJS()") {
                println("evaluateJavascript: $it")
            }
        }

    }
}