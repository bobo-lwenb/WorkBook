package com.workbook.liuwb.workbook.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.workbook.liuwb.workbook.databinding.ItemMainBinding
import com.workbook.liuwb.workbook.main.listener.OnItemClick
import com.workbook.liuwb.workbook.main.listener.OnItemLongClick

class RecyclerAdapter(
    private val data: List<String>,
    private val itemClick: OnItemClick,
    private val itemLongClick: OnItemLongClick
) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.button.text = data[position]
        holder.button.setOnClickListener { v -> itemClick.onItemClick(v, position) }
        holder.button.setOnLongClickListener { v -> itemLongClick.onitemLongClick(v, position); true }
    }

    inner class RecyclerViewHolder(binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val button: Button = binding.mainItem
    }
}