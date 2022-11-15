package com.syoon.toy.todo_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.syoon.toy.todo_list.databinding.ItemMemoBinding

class MemoAdapter(): RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    // private lateinit var binding: ItemMemoBinding
    var memoList: List<String>? = null

    inner class MemoViewHolder(private val binding: ItemMemoBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(str: String) {
            binding.memo = str
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        //memoList?.get(position)
        //holder.bind(memoList?.get(position) ?:)
        memoList?.let {
            holder.bind(it[position])
        }

       // val item = holder.itemView
    }

    override fun getItemCount(): Int {
        return memoList?.size ?: 0
    }
}