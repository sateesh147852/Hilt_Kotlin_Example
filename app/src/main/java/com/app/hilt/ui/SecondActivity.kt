package com.app.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.hilt.R
import com.app.hilt.adapter.NamesAdapter
import com.app.hilt.databinding.ActivitySecondBinding
import com.app.hilt.utilites.Utility
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

  private lateinit var binding: ActivitySecondBinding

  @Inject
  lateinit var namesAdapter: NamesAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySecondBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setRecyclerView()
  }

  private fun setRecyclerView() {
    binding.rvItems.layoutManager = LinearLayoutManager(this)
    binding.rvItems.adapter = namesAdapter
    namesAdapter.setData(Utility.getNames())
    namesAdapter.notifyDataSetChanged()
  }
}