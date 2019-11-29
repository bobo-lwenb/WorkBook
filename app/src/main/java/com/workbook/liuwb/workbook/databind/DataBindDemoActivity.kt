package com.workbook.liuwb.workbook.databind

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityDatabindDemoBinding
import kotlinx.android.synthetic.main.activity_databind_demo.*

class DataBindDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding = DataBindingUtil.setContentView<ActivityDatabindDemoBinding>(this, R.layout.activity_databind_demo)

        // Observable objects
        val demo = Demo("lwb", 27)
        databinding.bean = demo
        val button1 = change_object
        button1.setOnClickListener { demo.name = "liuwenbo" }

        // Observable Fields
        val user = User()
        user.userName.set("qazxsw")
        user.userAge.set(123)
        databinding.user = user
        val button2 = change_filed
        button2.setOnClickListener { user.userAge.set(123231) }

        // Observable Collections
        val list = ObservableArrayList<Any>()
        list.add("123")
        list.add(12)
        list.add("1welmflw")
        databinding.listIndex = 1
        databinding.list = list

        val map = ObservableArrayMap<String, Any>()
        map.put("1", "qwdq1")
        map.put("2", "qwdq2")
        map.put("3", "qwdq3")
        databinding.key = "2"
        databinding.map = map
        val collections = change_collections
        collections.setOnClickListener {
            databinding.listIndex = 2
            databinding.key = "3"
        }
    }
}