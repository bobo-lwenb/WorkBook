package com.workbook.liuwb.workbook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.listener.OnItemClick
import com.workbook.liuwb.workbook.listener.OnItemLongClick

class RecyAdapter(val context: Context, val data: ArrayList<String>, val itemClick: OnItemClick, val itemLongClick: OnItemLongClick) : RecyclerView.Adapter<RecyAdapter.RecyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        return RecyViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyViewHolder, position: Int) {
        holder.btn.text = data.get(position)
        holder.btn.setOnClickListener { v -> itemClick.onItemClick(v, position) }
        holder.btn.setOnLongClickListener { v -> itemLongClick.onitemLongClick(v, position); true }
    }

    inner class RecyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val btn = view.findViewById<Button>(R.id.main_item)

    }
}