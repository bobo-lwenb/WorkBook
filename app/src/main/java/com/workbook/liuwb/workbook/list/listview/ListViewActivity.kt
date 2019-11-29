package com.workbook.liuwb.workbook.list.listview

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_listview.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val myList: MutableList<ChatBean> = mutableListOf()
        val adapter = ChatAdapter(this, myList)
        list_view.adapter = adapter

        val textView = TextView(this)
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.layoutParams = params
        textView.text = "没有数据"
        (list_view.parent as ViewGroup).addView(textView)
        list_view.emptyView = textView

        val textView1 = TextView(this)
        val params1: AbsListView.LayoutParams = AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView1.layoutParams = params1
        textView1.text = "没有数据"

        val textView2 = TextView(this)
        val params2: AbsListView.LayoutParams = AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView2.layoutParams = params2
        textView2.text = "没有数据"

        list_view.addHeaderView(textView1)
        list_view.addFooterView(textView2)

        list_send.setOnClickListener {
            val bean: ChatBean = if (Math.random() < 0.5) {
                ChatBean(0, "left", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            } else {
                ChatBean(1, "right", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            }
            myList.add(bean)
            adapter.notifyDataSetChanged()
            list_view.setSelection(myList.size - 1)
        }
    }
}