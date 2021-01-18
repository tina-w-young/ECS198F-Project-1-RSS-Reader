package com.android.example.rssreader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter(private val topicList: MutableList<FeedTopic>): RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {
    class TopicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val topic_entry: LinearLayout = itemView.findViewById(R.id.topic_entry)
        val topic_title : TextView = itemView.findViewById(R.id.topic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.feed_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun getItemCount(): Int = topicList.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.topic_title.text = topicList[position].topic
    }
}