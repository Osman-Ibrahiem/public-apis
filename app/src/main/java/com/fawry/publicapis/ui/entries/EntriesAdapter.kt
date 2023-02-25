package com.fawry.publicapis.ui.entries

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fawry.domain.models.Entry
import com.fawry.publicapis.databinding.ItemEntryBinding
import com.fawry.publicapis.ui.base.BaseAdapter
import javax.inject.Inject

class EntriesAdapter @Inject constructor(
) : BaseAdapter<Entry>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem.category == newItem.category
        }

        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem == newItem
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemEntryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntryViewHolder(binding)
    }

    inner class EntryViewHolder(private val binding: ItemEntryBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<Entry> {

        override fun bind(item: Entry, position: Int) {
            binding.apply {
                textViewLink.text = item.link
                rootView.setCardBackgroundColor(if (item.isHttps) Color.GRAY else Color.WHITE)

                rootView.setOnClickListener {
                    onItemClickListener(item)
                }
            }
        }
    }

}