package com.minhldn.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.minhldn.demo.R
import com.minhldn.demo.model.ListStory


class ListStoryAdapter(private val listStory: List<ListStory>) :
    RecyclerView.Adapter<ListStoryAdapter.ListStoryViewHolder>() {
    class ListStoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgImageStory: ImageView = itemView.findViewById(R.id.imgItemStory)
        val txtTitleStory: TextView = itemView.findViewById(R.id.txtTitleStory)
        val txtDescriptionStory: TextView = itemView.findViewById(R.id.txtDescriptionStory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return ListStoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListStoryViewHolder, position: Int) {
        val currentStory = listStory[position]
        holder.txtTitleStory.text = currentStory.storyTitle
        holder.txtDescriptionStory.text = currentStory.storyDescription
        holder.imgImageStory.setImageResource(currentStory.imgItemStory)
    }

    override fun getItemCount(): Int {
        return listStory.size
    }
}