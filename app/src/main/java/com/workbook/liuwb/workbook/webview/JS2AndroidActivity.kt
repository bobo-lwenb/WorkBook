package com.workbook.liuwb.workbook.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_js2android.*

class JS2AndroidActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_js2android)

        val webSettings: WebSettings = js2_webview.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        js2_webview.loadUrl("file:///android_asset/js2android.html")
        // 1、通过定义与js通信的接口进行映射
        js2_webview.addJavascriptInterface(AndroidtoJs(), "test")

        // 2、通过shouldOverrideUrlLoading()方法回调拦截 url
        js2_webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                println(request!!.url)
                return true
            }
        }

        // 3、拦截JS对话框
        js2_webview.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                return super.onJsAlert(view, url, message, result)
            }

            override fun onJsPrompt(view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?): Boolean {
                println(message)
                return true
            }

            override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                return super.onJsConfirm(view, url, message, result)
            }
        }

    }

    inner class AndroidtoJs : Any() {

        // 定义JS需要调用的方法
        // 被JS调用的方法必须加入@JavascriptInterface注解
        @JavascriptInterface
        fun hello(msg: String) {
            println("JS调用了Android的hello方法")
        }
    }
}