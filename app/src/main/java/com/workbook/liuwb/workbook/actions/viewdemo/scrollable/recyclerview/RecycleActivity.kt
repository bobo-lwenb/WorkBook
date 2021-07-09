package com.workbook.liuwb.workbook.actions.viewdemo.scrollable.recyclerview

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.viewdemo.scrollable.listview.ChatBean
import com.workbook.liuwb.workbook.databinding.ActivityRecycleBinding

class RecycleActivity : AppCompatActivity() {

    private val binding: ActivityRecycleBinding by lazy {
        ActivityRecycleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mList: MutableList<ChatBean> = mutableListOf()
        val adapter = RecycleAdapter(this, mList)
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        binding.recycleView.layoutManager = manager
        binding.recycleView.adapter = adapter
        binding.recycleView.setHasFixedSize(true)

        binding.recycleSend.setOnClickListener {
            val bean: ChatBean = if (Math.random() < 0.5) {
                ChatBean(0, "left", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            } else {
                ChatBean(1, "right", BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            }
            mList.add(bean)
            adapter.notifyDataSetChanged()
            binding.recycleView.scrollToPosition(mList.size - 1)
        }
    }
}