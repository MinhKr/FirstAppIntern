package com.minhldn.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.minhldn.demo.model.Category
import com.minhldn.demo.R

class CategoryAdapter(private val category: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageCategory: ImageButton = itemView.findViewById(R.id.imgItemCategory)
        val iconTextCategory: TextView = itemView.findViewById(R.id.txtItemCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = category[position]
        holder.iconTextCategory.text = currentItem.categoryTitle
        holder.iconImageCategory.setImageResource(currentItem.categoryImage)
    }

    override fun getItemCount(): Int {
        return category.size
    }
}