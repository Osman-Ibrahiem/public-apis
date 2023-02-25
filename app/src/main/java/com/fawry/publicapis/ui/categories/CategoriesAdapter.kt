package com.fawry.publicapis.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fawry.domain.models.Category
import com.fawry.publicapis.databinding.ItemCategoryBinding
import com.fawry.publicapis.ui.base.BaseAdapter
import javax.inject.Inject

class CategoriesAdapter @Inject constructor(
) : BaseAdapter<Category>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.category == newItem.category
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root), Binder<Category> {

        override fun bind(item: Category, position: Int) {
            binding.apply {
                textViewCategoryName.text = item.category
                textViewEntriesNum.text = item.entriesCount.toString()

                rootView.setOnClickListener {
                    onItemClickListener(item)
                }
            }
        }
    }

}