package com.syoon.toy.todo_list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.syoon.toy.todo_list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val memoList: MutableList<String> = mutableListOf()
    private val adapter = MemoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initListener()
        initRecyclerView()

        //binding.memo = memoList
    }

    private fun initRecyclerView() {
        binding.rvMemoList.layoutManager = LinearLayoutManager(this)
        binding.rvMemoList.adapter = adapter
        adapter.memoList = memoList
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initListener() {
        binding.btnSave.setOnClickListener {
            memoList.add(binding.edtMemo.text.toString())
            binding.edtMemo.text.clear()
            binding.rvMemoList.adapter?.notifyDataSetChanged()
        }
    }
}