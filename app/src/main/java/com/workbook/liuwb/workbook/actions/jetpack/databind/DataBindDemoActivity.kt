package com.workbook.liuwb.workbook.actions.jetpack.databind

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityDatabindDemoBinding

class DataBindDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityDatabindDemoBinding>(this, R.layout.activity_databind_demo)

        // Observable objects
        val demo = Demo("lwb", 27)
        dataBinding.bean = demo
        val button1 = findViewById<Button>(R.id.change_object)
        button1.setOnClickListener { demo.name = "liuwenbo" }

        // Observable Fields
        val user = User()
        user.userName.set("qazxsw")
        user.userAge.set(123)
        dataBinding.user = user
        val button2 = findViewById<Button>(R.id.change_filed)
        button2.setOnClickListener { user.userAge.set(123231) }

        // Observable Collections
        val list = ObservableArrayList<Any>()
        list.add("123")
        list.add(12)
        list.add("1welmflw")
        dataBinding.listIndex = 1
        dataBinding.list = list

        val map = ObservableArrayMap<String, Any>()
        map.put("1", "qwdq1")
        map.put("2", "qwdq2")
        map.put("3", "qwdq3")
        dataBinding.key = "2"
        dataBinding.map = map
        val collections = findViewById<Button>(R.id.change_collections)
        collections.setOnClickListener {
            dataBinding.listIndex = 2
            dataBinding.key = "3"
        }
    }
}