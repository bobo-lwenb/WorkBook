package com.workbook.liuwb.workbook

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.aboutview.ViewMainActivity
import com.workbook.liuwb.workbook.adapters.RecyAdapter
import com.workbook.liuwb.workbook.aidl.BookManagerActivity
import com.workbook.liuwb.workbook.annotation.AnnoActivity
import com.workbook.liuwb.workbook.autosize.AutoSizeActivity
import com.workbook.liuwb.workbook.aboutview.carousel.CarouselActivity
import com.workbook.liuwb.workbook.databind.DataBindDemoActivity
import com.workbook.liuwb.workbook.eventbus.EventOneActivity
import com.workbook.liuwb.workbook.flutter.TestFlutterActivity
import com.workbook.liuwb.workbook.fragment.LifeCycleActivity
import com.workbook.liuwb.workbook.glide.GlideActivity
import com.workbook.liuwb.workbook.jsonparse.JsonActivity
import com.workbook.liuwb.workbook.launchmode.LaunchMainActivity
import com.workbook.liuwb.workbook.list.listview.ListViewActivity
import com.workbook.liuwb.workbook.list.recyclerview.RecycleActivity
import com.workbook.liuwb.workbook.listener.OnItemClick
import com.workbook.liuwb.workbook.listener.OnItemLongClick
import com.workbook.liuwb.workbook.material.MaterialActivity
import com.workbook.liuwb.workbook.menu.MenuDemoActivity
import com.workbook.liuwb.workbook.mvp.v1.view.UserActivity
import com.workbook.liuwb.workbook.service.bind.messenger.MessengerActivity
import com.workbook.liuwb.workbook.notification.NotificationDemoActivity
import com.workbook.liuwb.workbook.permission.PermissionActivity
import com.workbook.liuwb.workbook.reflect.ReflectActivity
import com.workbook.liuwb.workbook.refreshandloadmore.RefreshLoadMainActivity
import com.workbook.liuwb.workbook.retrofit.RetrofitActivity
import com.workbook.liuwb.workbook.rxjava.RxJavaActivity
import com.workbook.liuwb.workbook.scoket.demo1.TCPClientActivity
import com.workbook.liuwb.workbook.service.bind.foregroundservice.ForegroundServiceActivity
import com.workbook.liuwb.workbook.webview.Android2JSActivity
import com.workbook.liuwb.workbook.webview.JS2AndroidActivity
import kotlinx.android.synthetic.main.activity_main_new.*

class MainNewActivity : AppCompatActivity(), OnItemClick, OnItemLongClick {

    private val datas: ArrayList<String> = arrayListOf("glide", "carousel", "start_service", "bind_service", "ForegroundService",
            "receiver", "messenger_service", "aidl", "databind", "rxjava", "annotation", "reflect", "eventbus",
            "retrofit", "autosize", "Material Design", "launchMode", "notification", "menu", "Refresh and Loadmore",
            "flutter", "permission", "view体系", "handler", "lifecycle", "mvp_v1", "android2js", "js2android", "json", "listview", "recycle_view",
            "tcp_scoket")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)

        val toolbar = toolbar_main
        setSupportActionBar(toolbar)

        val recyclerView = mainnew_recyclerview

        val adapter = RecyAdapter(this, datas, this, this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Logger.e("MainNewActivity: onConfigurationChanged")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Logger.e("MainNewActivity: onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Logger.e("MainNewActivity: onRestoreInstanceState")
    }

    override fun onItemClick(view: View?, position: Int) {
        val str = datas.get(position)
        val intent: Intent
        when (str) {
            "glide" -> {
                intent = Intent(this@MainNewActivity, GlideActivity::class.java)
                startActivity(intent)
            }
            "carousel" -> {
                intent = Intent(this@MainNewActivity, CarouselActivity::class.java)
                startActivity(intent)
            }
            "start_service" -> {
            }
            "bind_service" -> {
            }
            "ForegroundService" -> {
                intent = Intent(this@MainNewActivity, ForegroundServiceActivity::class.java)
                startActivity(intent)
            }
            "receiver" -> {

            }
            "messenger_service" -> {
                intent = Intent(this@MainNewActivity, MessengerActivity::class.java)
                startActivity(intent)
            }
            "aidl" -> {
                intent = Intent(this@MainNewActivity, BookManagerActivity::class.java)
                startActivity(intent)
            }
            "databind" -> {
                intent = Intent(this@MainNewActivity, DataBindDemoActivity::class.java)
                startActivity(intent)
            }
            "rxjava" -> {
                intent = Intent(this@MainNewActivity, RxJavaActivity::class.java)
                startActivity(intent)
            }
            "annotation" -> {
                intent = Intent(this@MainNewActivity, AnnoActivity::class.java)
                startActivity(intent)
            }
            "reflect" -> {
                intent = Intent(this@MainNewActivity, ReflectActivity::class.java)
                startActivity(intent)
            }
            "eventbus" -> {
                intent = Intent(this@MainNewActivity, EventOneActivity::class.java)
                startActivity(intent)
            }
            "retrofit" -> {
                intent = Intent(this@MainNewActivity, RetrofitActivity::class.java)
                startActivity(intent)
            }
            "autosize" -> {
                intent = Intent(this@MainNewActivity, AutoSizeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            "Material Design" -> {
                intent = Intent(this@MainNewActivity, MaterialActivity::class.java)
                startActivity(intent)
            }
            "launchMode" -> {
                intent = Intent(this@MainNewActivity, LaunchMainActivity::class.java)
                startActivity(intent)
            }
            "notification" -> {
                intent = Intent(this@MainNewActivity, NotificationDemoActivity::class.java)
                startActivity(intent)
            }
            "menu" -> {
                intent = Intent(this@MainNewActivity, MenuDemoActivity::class.java)
                startActivity(intent)
            }
            "Refresh and Loadmore" -> {
                intent = Intent(this@MainNewActivity, RefreshLoadMainActivity::class.java)
                startActivity(intent)
            }
            "flutter" -> {
                intent = Intent(this@MainNewActivity, TestFlutterActivity::class.java)
                startActivity(intent)
            }
            "permission" -> {
                intent = Intent(this@MainNewActivity, PermissionActivity::class.java)
                startActivity(intent)
            }
            "view体系" -> {
                intent = Intent(this@MainNewActivity, ViewMainActivity::class.java)
                startActivity(intent)
            }
            "handler" -> {

            }
            "lifecycle" -> {
                intent = Intent(this@MainNewActivity, LifeCycleActivity::class.java)
                startActivity(intent)
            }
            "mvp_v1" -> {
                intent = Intent(this@MainNewActivity, UserActivity::class.java)
                startActivity(intent)
            }
            "android2js" -> {
                intent = Intent(this@MainNewActivity, Android2JSActivity::class.java)
                startActivity(intent)
            }
            "js2android" -> {
                intent = Intent(this@MainNewActivity, JS2AndroidActivity::class.java)
                startActivity(intent)
            }
            "json" -> {
                intent = Intent(this@MainNewActivity, JsonActivity::class.java)
                startActivity(intent)
            }
            "listview" -> {
                intent = Intent(this@MainNewActivity, ListViewActivity::class.java)
                startActivity(intent)
            }
            "recycle_view" -> {
                intent = Intent(this@MainNewActivity, RecycleActivity::class.java)
                startActivity(intent)
            }
            "tcp_scoket" -> {
                intent = Intent(this@MainNewActivity, TCPClientActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onitemLongClick(view: View?, position: Int) {
    }

    override fun onBackPressed() {
        val intent = Intent("android.intent.action.MAIN")
        intent.addCategory("android.intent.category.HOME")
        startActivity(intent)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

}