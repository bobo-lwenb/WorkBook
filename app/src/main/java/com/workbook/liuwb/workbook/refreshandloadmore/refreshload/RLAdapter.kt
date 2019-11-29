package com.workbook.liuwb.workbook.refreshandloadmore.refreshload

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.workbook.liuwb.workbook.R

class RLAdapter(val context: Context, private val lists: List<String>) : BaseAdapter() {

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View
        val viewHolder: RLViewHolder
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_list, null)
            viewHolder = RLViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as RLViewHolder
        }
        val string = getItem(position)
        viewHolder.content.text = string.toString()
        return view
    }

    override fun getItem(position: Int): Any = lists[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = lists.size

    private inner class RLViewHolder(view: View) {
        var content: TextView = view.findViewById(R.id.item_text)
    }
}