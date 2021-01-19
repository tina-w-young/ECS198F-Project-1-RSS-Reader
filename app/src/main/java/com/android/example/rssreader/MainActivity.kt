package com.android.example.rssreader

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ========== PHASE 3 : from here ==========================================================
        // TODO: Add RecyclerView here for all "feeds by topic" options
        //  found on https://news.un.org/en/rss-feeds

         val topicList = mutableListOf<FeedTopic>(
            FeedTopic("Health", "health"),
            FeedTopic("UN Affairs", "un-affairs"),
            FeedTopic("Law and Crime Prevention", "law-and-crime-prevention"),
            FeedTopic("Human Rights",  "human-rights"),
            FeedTopic("Humanitarian Aid", "humanitarian-aid"),
            FeedTopic("Climate Change", "climate-change"),
            FeedTopic("Culture and Education", "culture-and-education"),
            FeedTopic("Economic Development", "economic-development"),
            FeedTopic("Women", "women"),
            FeedTopic("Peace and Security", "peace-and-security"),
            FeedTopic("Migrants and Refugees", "migrants-and-refugees"),
            FeedTopic("SDGs", "sdgs")
        )

        val rv: RecyclerView = findViewById<RecyclerView>(R.id.recycler_view_main)
        rv.layoutManager = LinearLayoutManager(this@MainActivity)
        rv.adapter = TopicAdapter(topicList)

        // ========== PHASE 3 : to here ============================================================
    }
}
