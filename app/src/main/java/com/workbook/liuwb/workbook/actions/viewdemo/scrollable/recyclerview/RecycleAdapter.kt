package com.workbook.liuwb.workbook.actions.viewdemo.scrollable.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.viewdemo.scrollable.listview.ChatBean

class RecycleAdapter(val context: Context, val list: MutableList<ChatBean>) : RecyclerView.Adapter<RecycleAdapter.RViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val view: View = if (viewType == 0) {
            LayoutInflater.from(context).inflate(R.layout.item_listview_left, parent, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.item_listview_right, parent, false)
        }
        return RViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        val data = list[position]
        holder.icon.setImageBitmap(data.icon)
        holder.content.text = data.content
    }

    inner class RViewHolder(view: View, val type: Int) : RecyclerView.ViewHolder(view) {

        var icon: ImageView
        var content: TextView

        init {
            if (type == 0) {
                icon = view.findViewById(R.id.left_icon)
                content = view.findViewById(R.id.left_content)
            } else {
                icon = view.findViewById(R.id.right_icon)
                content = view.findViewById(R.id.right_content)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].type
}