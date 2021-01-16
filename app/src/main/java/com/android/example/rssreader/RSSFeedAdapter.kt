package com.android.example.rssreader

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item

class RSSFeedAdapter(private val rssFeedList: MutableList<Item>):RecyclerView.Adapter<RSSFeedAdapter.RSSFeedViewHolder>() {
    class RSSFeedViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val articleentry = itemView.findViewById<LinearLayout>(R.id.article_entry)
    }

}