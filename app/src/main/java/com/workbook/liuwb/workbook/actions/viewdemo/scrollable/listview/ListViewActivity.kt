package com.workbook.liuwb.workbook.actions.viewdemo.scrollable.listview

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityListviewBinding

class ListViewActivity : AppCompatActivity() {

    private val binding: ActivityListviewBinding by lazy {
        ActivityListviewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myList: MutableList<ChatBean> = mutableListOf()
        val adapter = ChatAdapter(this, myList)
        binding.listView.adapter = adapter

        val textView = TextView(this)
        val params: ViewGroup.LayoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.layoutParams = params
        textView.text = "没有数据"
        (binding.listView.parent as ViewGroup).addView(textView)
        binding.listView.emptyView = textView

        val textView1 = TextView(this)
        val params1: AbsListView.LayoutParams =
            AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView1.layoutParams = params1
        textView1.text = "没有数据"

        val textView2 = TextView(this)
        val params2: AbsListView.LayoutParams =
            AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView2.layoutParams = params2
        textView2.text = "没有数据"

        binding.listView.addHeaderView(textView1)
        binding.listView.addFooterView(textView2)

        binding.listSend.setOnClickListener {
            val bean: ChatBean = if (Math.random() < 0.5) {
                ChatBean(0, "left", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            } else {
                ChatBean(1, "right", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            }
            myList.add(bean)
            adapter.notifyDataSetChanged()
            binding.listView.setSelection(myList.size - 1)
        }
    }
}