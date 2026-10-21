package com.example.internship_project.recyclerViewActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internship_project.databinding.ItemLayoutBinding

class ItemAdapter(var itemList: List<String>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding =
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(itemList[position])
        }
    }

    inner class ItemViewHolder(val binding: ItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(itemName: String) {
            binding.tvItemName.text = itemName
        }

    }

}