package com.workbook.liuwb.workbook.list.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.workbook.liuwb.workbook.R

class ChatAdapter(val context: Context, val list: MutableList<ChatBean>) : BaseAdapter() {

    private var mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var tempView: View? = convertView
        val viewHolder: MyViewHolder

        if (tempView == null) {
            viewHolder = MyViewHolder()
            if (getItemViewType(position) == 0) {
                tempView = mInflater.inflate(R.layout.item_listview_left, null)
                viewHolder.icon = tempView.findViewById(R.id.left_icon)
                viewHolder.content = tempView.findViewById(R.id.left_content)
            } else {
                tempView = mInflater.inflate(R.layout.item_listview_right, null)
                viewHolder.icon = tempView.findViewById(R.id.right_icon)
                viewHolder.content = tempView.findViewById(R.id.right_content)
            }
            tempView?.tag = viewHolder
        } else {
            viewHolder = tempView.tag as MyViewHolder
        }

        viewHolder.icon?.setImageBitmap(list[position].icon)
        viewHolder.content?.text = list[position].content
        return tempView!!
    }

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list[position].type

    override fun getViewTypeCount(): Int = 2

    inner class MyViewHolder {
        var icon: ImageView? = null
        var content: TextView? = null

    }
}
