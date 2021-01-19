package com.android.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class TopicAdapter(private val topicList: MutableList<FeedTopic>): RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {
    class TopicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val topic_entry: LinearLayout = itemView.findViewById(R.id.topic_entry)
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
        holder.topic_entry.setOnClickListener {
         //   Toast.makeText(it.context, holder.topic_title.text, Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context, FeedActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}
