package com.workbook.liuwb.workbook.list.recyclerview

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.list.listview.ChatBean
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        val mList: MutableList<ChatBean> = mutableListOf()
        val adapter = RecycleAdapter(this, mList)
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        recycle_view.layoutManager = manager
        recycle_view.adapter = adapter
        recycle_view.setHasFixedSize(true)

        recycle_send.setOnClickListener {
            val bean: ChatBean = if (Math.random() < 0.5) {
                ChatBean(0, "left", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            } else {
                ChatBean(1, "right", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            }
            mList.add(bean)
            adapter.notifyDataSetChanged()
            recycle_view.scrollToPosition(mList.size - 1)
        }
    }
}