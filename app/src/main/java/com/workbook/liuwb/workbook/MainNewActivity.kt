package com.workbook.liuwb.workbook

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.mylibrary.utils.DensityUtil
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.aboutview.GeneralDialog
import com.workbook.liuwb.workbook.aboutview.ViewMainActivity
import com.workbook.liuwb.workbook.aboutview.customviewgroup.carousel.CarouselActivity
import com.workbook.liuwb.workbook.adapters.RecyAdapter
import com.workbook.liuwb.workbook.aidl.BookManagerActivity
import com.workbook.liuwb.workbook.annotation.AnnoActivity
import com.workbook.liuwb.workbook.anrdemo.ANRActivity
import com.workbook.liuwb.workbook.autosize.AutoSizeActivity
import com.workbook.liuwb.workbook.dagger.DaggerActivity1
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
import com.workbook.liuwb.workbook.memory.Memory1Activity
import com.workbook.liuwb.workbook.menu.MenuDemoActivity
import com.workbook.liuwb.workbook.mvp.v1.view.UserActivity
import com.workbook.liuwb.workbook.notification.NotificationDemoActivity
import com.workbook.liuwb.workbook.permission.PermissionActivity
import com.workbook.liuwb.workbook.propertyanimation.LayoutAnimationsActivity
import com.workbook.liuwb.workbook.propertyanimation.evaluator.PointEvaluatorActivity
import com.workbook.liuwb.workbook.provider.base.ClientActivity
import com.workbook.liuwb.workbook.reflect.ReflectActivity
import com.workbook.liuwb.workbook.refreshandloadmore.RefreshLoadMainActivity
import com.workbook.liuwb.workbook.retrofit.RetrofitActivity
import com.workbook.liuwb.workbook.rxjava.RxJavaActivity
import com.workbook.liuwb.workbook.scoket.demo1.TCPClientActivity
import com.workbook.liuwb.workbook.service.bind.foregroundservice.ForegroundServiceActivity
import com.workbook.liuwb.workbook.service.bind.messenger.MessengerActivity
import com.workbook.liuwb.workbook.webview.Android2JSActivity
import com.workbook.liuwb.workbook.webview.JS2AndroidActivity
import kotlinx.android.synthetic.main.activity_main_new.*

class MainNewActivity : AppCompatActivity(), OnItemClick, OnItemLongClick {

    private lateinit var data: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)

        
        Log.e("11111111111", (100 <= 1700).toString())

        DensityUtil.setCustomDensity(application, this)

        val toolbar = toolbar_main
        setSupportActionBar(toolbar)

        val recyclerView = mainnew_recyclerview

        data = resources.getStringArray(R.array.main_item).toList()
        val adapter = RecyAdapter(this, data, this, this)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView!!.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        getSharedPreferences("", Context.MODE_PRIVATE).modify {
            putBoolean("", false)
        }
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
        val intent: Intent
        when (data[position]) {
            "glide", "glide" -> {
                intent = Intent(this@MainNewActivity, GlideActivity::class.java)
//                intent = Intent(this@MainNewActivity, ANRActivity::class.java)
                startActivity(intent)
            }
            "内存管理", "memory manage" -> {
                intent = Intent(this@MainNewActivity, Memory1Activity::class.java)
                startActivity(intent)
            }
            "carousel", "轮播图" -> {
                intent = Intent(this@MainNewActivity, CarouselActivity::class.java)
                startActivity(intent)
            }
            "start_service", "启动服务" -> {
            }
            "bind_service", "绑定服务" -> {
                intent = Intent(this@MainNewActivity, MessengerActivity::class.java)
                startActivity(intent)
            }
            "ForegroundService", "前台服务" -> {
                intent = Intent(this@MainNewActivity, ForegroundServiceActivity::class.java)
                startActivity(intent)
            }
            "receiver", "广播接收者" -> {

            }
            "messenger_service", "消息服务" -> {
                intent = Intent(this@MainNewActivity, MessengerActivity::class.java)
                startActivity(intent)
            }
            "aidl", "aidl" -> {
                intent = Intent(this@MainNewActivity, BookManagerActivity::class.java)
                startActivity(intent)
            }
            "databind", "数据绑定" -> {
                intent = Intent(this@MainNewActivity, DataBindDemoActivity::class.java)
                startActivity(intent)
            }
            "rxjava", "rxjava" -> {
                intent = Intent(this@MainNewActivity, RxJavaActivity::class.java)
                startActivity(intent)
            }
            "annotation", "注解" -> {
                intent = Intent(this@MainNewActivity, AnnoActivity::class.java)
                startActivity(intent)
            }
            "reflect", "反射" -> {
                intent = Intent(this@MainNewActivity, ReflectActivity::class.java)
                startActivity(intent)
            }
            "eventbus", "eventbus" -> {
                intent = Intent(this@MainNewActivity, EventOneActivity::class.java)
                startActivity(intent)
            }
            "retrofit", "retrofit" -> {
                intent = Intent(this@MainNewActivity, RetrofitActivity::class.java)
                startActivity(intent)
            }
            "autosize", "autosize" -> {
                intent = Intent(this@MainNewActivity, AutoSizeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            "Material Design", "Material Design" -> {
                intent = Intent(this@MainNewActivity, MaterialActivity::class.java)
                startActivity(intent)
            }
            "launchMode", "activity加载模式" -> {
                intent = Intent(this@MainNewActivity, LaunchMainActivity::class.java)
                startActivity(intent)
            }
            "notification", "通知" -> {
                intent = Intent(this@MainNewActivity, NotificationDemoActivity::class.java)
                startActivity(intent)
            }
            "menu", "菜单" -> {
                intent = Intent(this@MainNewActivity, MenuDemoActivity::class.java)
                startActivity(intent)
            }
            "Refresh and Loadmore", "Refresh and Loadmore" -> {
                intent = Intent(this@MainNewActivity, RefreshLoadMainActivity::class.java)
                startActivity(intent)
            }
            "flutter", "flutter" -> {
                intent = Intent(this@MainNewActivity, TestFlutterActivity::class.java)
                startActivity(intent)
            }
            "permission", "权限" -> {
                intent = Intent(this@MainNewActivity, PermissionActivity::class.java)
                startActivity(intent)
            }
            "view system", "view体系" -> {
                intent = Intent(this@MainNewActivity, ViewMainActivity::class.java)
                startActivity(intent)
            }
            "handler", "handler" -> {

            }
            "lifecycle", "生命周期" -> {
                intent = Intent(this@MainNewActivity, LifeCycleActivity::class.java)
                startActivity(intent)
            }
            "mvp_v1", "mvp_v1" -> {
                intent = Intent(this@MainNewActivity, UserActivity::class.java)
                startActivity(intent)
            }
            "android2js", "android2js" -> {
                intent = Intent(this@MainNewActivity, Android2JSActivity::class.java)
                startActivity(intent)
            }
            "js2android", "js2android" -> {
                intent = Intent(this@MainNewActivity, JS2AndroidActivity::class.java)
                startActivity(intent)
            }
            "json", "json" -> {
                intent = Intent(this@MainNewActivity, JsonActivity::class.java)
                startActivity(intent)
            }
            "listview", "listview" -> {
                intent = Intent(this@MainNewActivity, ListViewActivity::class.java)
                startActivity(intent)
            }
            "recycle_view", "recycle_view" -> {
                intent = Intent(this@MainNewActivity, RecycleActivity::class.java)
                startActivity(intent)
            }
            "tcp_scoket", "tcp_scoket" -> {
                intent = Intent(this@MainNewActivity, TCPClientActivity::class.java)
                startActivity(intent)
            }
            "property1", "property1" -> {
                intent = Intent(this@MainNewActivity, LayoutAnimationsActivity::class.java)
                startActivity(intent)
            }
            "TypeEvaluator", "TypeEvaluator" -> {
                intent = Intent(this@MainNewActivity, PointEvaluatorActivity::class.java)
                startActivity(intent)
            }
            "customdialog", "自定义对话框1" -> {
                showDialog("11111", "adafsfgfgdg", "cancel", "ok", {
                    Toast.makeText(this, "left", Toast.LENGTH_SHORT).show()
                }, {
                    Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
                })
            }
            "generaldialog", "自定义对话框2" -> {
                GeneralDialog.Builder(this)
                        .setContentView(R.layout.dialog_general)
                        .setText(R.id.title, "notice!!")
                        .setText(R.id.content, "hfehvighibhgtribrgbvglfbjfgbjfgb")
                        .setText(R.id.left, "cancel")
                        .setCLickListener(R.id.left) { dialog, view ->
                            dialog.dismiss()
                        }
                        .setText(R.id.right, "OK")
                        .setCLickListener(R.id.right) { dialog, view ->
                            dialog.dismiss()
                        }
                        .build()
                        .show(supportFragmentManager, "su")
            }
            "Dagger2" -> {
                intent = Intent(this@MainNewActivity, DaggerActivity1::class.java)
                startActivity(intent)
            }
            "ContentProvider" -> {
                intent = Intent(this@MainNewActivity, ClientActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun showDialog(titleText: String, content: String, leftText: String, rightTetx: String, leftClick: OnLeftClick, rightClick: OnRightClick) {

        val view = LayoutInflater.from(this).inflate(R.layout.fragment_common_dialog, null, false)

        val dialog = AlertDialog.Builder(this)
                .setView(view)
                .create()

        view.findViewById<TextView>(R.id.titleT).text = titleText
        view.findViewById<TextView>(R.id.contentT).text = content
        view.findViewById<TextView>(R.id.left).text = leftText
        view.findViewById<TextView>(R.id.right).text = rightTetx

        view.findViewById<TextView>(R.id.left).setOnClickListener {
            dialog.dismiss()
            leftClick()
        }

        view.findViewById<TextView>(R.id.right).setOnClickListener {
            dialog.dismiss()
            rightClick()
        }
        dialog.setCanceledOnTouchOutside(false)

        dialog.show()
        val point = Point()
        windowManager.defaultDisplay.getSize(point)

        val attr = dialog.window?.attributes

        attr?.width = (point.x * 0.6).toInt()

        dialog.window?.attributes = attr
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

    override fun onDestroy() {
        super.onDestroy()
        DensityUtil.releaseDensity(application)
    }

}
typealias OnLeftClick = () -> Unit
typealias OnRightClick = () -> Unit