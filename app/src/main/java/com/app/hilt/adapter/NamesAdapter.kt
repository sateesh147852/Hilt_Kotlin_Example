package com.app.hilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.hilt.databinding.NamesItemBinding

class NamesAdapter : RecyclerView.Adapter<NamesAdapter.NamesViewHolder>() {

  private var names = ArrayList<String>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
    val binding = NamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return NamesViewHolder(binding)
  }

  override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
    holder.binding.tvNames.text = names[position]
  }

  override fun getItemCount(): Int {
    return names?.size ?: 0
  }

  public fun setData(data: ArrayList<String>) {
    this.names = data
  }

  class NamesViewHolder(var binding: NamesItemBinding) : RecyclerView.ViewHolder(binding.root)
}