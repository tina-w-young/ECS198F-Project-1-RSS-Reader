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
        // ========== PHASE 3 : to here ============================================================

        // ========== PHASE 3 : Remove this section if needed from here ============================
        // TODO: Remove this section
        /* Send User to FeedActivity to view UN News Article by Topic */
        val topic = FeedTopic("Health", "health")
         // TODO: try switching above line with below and see what happens on FeedActivity Page
        // val topic = FeedTopic("Human Rights", "human-rights")

        val intent = Intent(this, FeedActivity::class.java)
        intent.putExtra("feed", topic)
        this.startActivity(intent)

        // ========== PHASE 3 : to here ============================================================

         val baseUrl = "https://news.un.org/feed/subscribe/en/news/"

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

      //  findViewById<TextView>(R.id.topic_entry).setOnClickListener {
         //   val topic = FeedTopic("Health", baseUrl + "health")
           // val intent = Intent(this, FeedActivity::class.java)
            //intent.putExtra("FeedTopic", topic)
            //this.startActivity(intent)
       // }
    }
}
