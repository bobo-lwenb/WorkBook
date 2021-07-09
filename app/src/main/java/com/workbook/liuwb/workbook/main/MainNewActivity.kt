package com.workbook.liuwb.workbook.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.mylibrary.utils.DensityUtil
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.animation.AnimationActivity
import com.workbook.liuwb.workbook.actions.appstructure.StructureMainActivity
import com.workbook.liuwb.workbook.actions.customview.CustomViewMainActivity
import com.workbook.liuwb.workbook.actions.function.FunctionMainActivity
import com.workbook.liuwb.workbook.actions.jetpack.JetpackActivity
import com.workbook.liuwb.workbook.actions.material.MaterialActivity
import com.workbook.liuwb.workbook.actions.memorymanage.MemoryActivity
import com.workbook.liuwb.workbook.actions.provider.ProviderActivity
import com.workbook.liuwb.workbook.actions.service.ServiceMainActivity
import com.workbook.liuwb.workbook.actions.third.ThirdMainActivity
import com.workbook.liuwb.workbook.actions.viewdemo.ViewDemoActivity
import com.workbook.liuwb.workbook.actions.webview.WebViewActivity
import com.workbook.liuwb.workbook.databinding.ActivityMainNewBinding
import com.workbook.liuwb.workbook.main.listener.OnItemClick
import com.workbook.liuwb.workbook.main.listener.OnItemLongClick

class MainNewActivity : AppCompatActivity(), OnItemClick, OnItemLongClick {

    private val data: List<String> by lazy {
        resources.getStringArray(R.array.main_item).toList()
    }

    private val binding: ActivityMainNewBinding by lazy {
        ActivityMainNewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        DensityUtil.setCustomDensity(application, this)
        setSupportActionBar(binding.toolbarMain)

        val adapter = RecyclerAdapter(data, this, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.mainnewRecyclerview.layoutManager = layoutManager
        binding.mainnewRecyclerview.adapter = adapter
        binding.mainnewRecyclerview.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.mainnewRecyclerview.addItemDecoration(itemDecoration)
    }

    override fun onDestroy() {
        super.onDestroy()
        DensityUtil.releaseDensity(application)
    }

    override fun onItemClick(view: View?, position: Int) {
        val intent: Intent
        when (data[position]) {
            "内存管理" -> {
                intent = Intent(this, MemoryActivity::class.java)
                startActivity(intent)
            }
            "Service" -> {
                intent = Intent(this, ServiceMainActivity::class.java)
                startActivity(intent)
            }
            "ContentProvider" -> {
                intent = Intent(this, ProviderActivity::class.java)
                startActivity(intent)
            }
            "广播接收者" -> {
            }
            "Jetpack" -> {
                intent = Intent(this, JetpackActivity::class.java)
                startActivity(intent)
            }
            "Material Design" -> {
                intent = Intent(this, MaterialActivity::class.java)
                startActivity(intent)
            }
            "WebView" -> {
                intent = Intent(this, WebViewActivity::class.java)
                startActivity(intent)
            }
            "控件例子" -> {
                intent = Intent(this, ViewDemoActivity::class.java)
                startActivity(intent)
            }
            "自定义View" -> {
                intent = Intent(this, CustomViewMainActivity::class.java)
                startActivity(intent)
            }
            "动画" -> {
                intent = Intent(this, AnimationActivity::class.java)
                startActivity(intent)
            }
            "系统功能" -> {
                intent = Intent(this, FunctionMainActivity::class.java)
                startActivity(intent)
            }
            "应用结构" -> {
                intent = Intent(this, StructureMainActivity::class.java)
                startActivity(intent)
            }
            "设计模式" -> {
            }
            "第三方框架" -> {
                intent = Intent(this, ThirdMainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onitemLongClick(view: View?, position: Int) {}
}