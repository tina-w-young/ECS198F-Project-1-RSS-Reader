package com.android.example.rssreader

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item

class RSSFeedAdapter(private val rssFeedList: MutableList<Item>):RecyclerView.Adapter<RSSFeedAdapter.RSSFeedViewHolder>() {
    class RSSFeedViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
<<<<<<< HEAD
        val articleentry = itemView.findViewById<LinearLayout>(R.id.article_entry)
=======
        val articleentry = itemView.findViewById<LinearLayout>(R.id.articleentry)
        //hi
>>>>>>> 6747ea86ca28fab18eabed22cdf3cc371e91a83c
    }

}