package com.scottyab.rootbeer.sample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scottyab.rootbeer.sample.RootItemResult
import com.scottyab.rootbeer.sample.databinding.ItemRootCheckBinding

class RootItemAdapter : RecyclerView.Adapter<RootItemAdapter.RootItemVH>() {
    private lateinit var binding: ItemRootCheckBinding
    private val items: MutableList<RootItemResult> = mutableListOf()

    fun update(results: List<RootItemResult>) {
        items.clear()
        items.addAll(results)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootItemVH {
        binding = ItemRootCheckBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val inflater = LayoutInflater.from(parent.context)
        return RootItemVH(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RootItemVH, position: Int) = holder.bind(items[position])

    fun add(rootItemResult: RootItemResult) {
        items.add(rootItemResult)
        notifyItemInserted(items.size - 1)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    class RootItemVH(private val binding: ItemRootCheckBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RootItemResult) {
            binding.rootItemText.text = item.text
            binding.rootItemResultIcon.update(isRooted = item.result)
        }
    }
}


