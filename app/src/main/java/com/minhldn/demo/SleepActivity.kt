package com.minhldn.demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minhldn.demo.adapter.CategoryAdapter
import com.minhldn.demo.adapter.ListStoryAdapter
import com.minhldn.demo.model.Category
import com.minhldn.demo.model.ListStory

class SleepActivity : AppCompatActivity() {
    private lateinit var rvCategorySelection: RecyclerView
    private lateinit var rvListStories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sleep)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvCategorySelection = findViewById(R.id.rvCategorySelection)
        rvListStories = findViewById(R.id.rvListStories)

        //Category
        rvCategorySelection.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val categories = listOf(
            Category(R.drawable.ic_all, "All"),
            Category(R.drawable.ic_my, "My"),
            Category(R.drawable.ic_anxious, "Anxious"),
            Category(R.drawable.ic_sleep, "Sleep"),
            Category(R.drawable.ic_kids, "Kids")
        )

        rvCategorySelection.adapter = CategoryAdapter(categories)

        //List Stories
        rvListStories.layoutManager = GridLayoutManager(this, 2)
        rvListStories.isNestedScrollingEnabled = false

        val listStories = listOf(
            ListStory(R.drawable.img1, "Night Island", "45 MIN • SLEEP MUSIC"),
            ListStory(R.drawable.img2, "The Ocean Moon", "45 MIN • SLEEP MUSIC"),
        )
        rvListStories.adapter = ListStoryAdapter(listStories)

    }

}