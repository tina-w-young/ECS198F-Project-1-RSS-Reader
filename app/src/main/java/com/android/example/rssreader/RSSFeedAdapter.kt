package com.android.example.rssreader

import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item
import kotlinx.android.parcel.Parcelize
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import org.w3c.dom.Text

class RSSFeedAdapter(private val rssFeedList: MutableList<Item>):RecyclerView.Adapter<RSSFeedAdapter.RSSFeedViewHolder>() {
    class RSSFeedViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val article_entry: LinearLayout = itemView.findViewById(R.id.article_entry)
        val date : TextView = itemView.findViewById(R.id.date)
        val title : TextView = itemView.findViewById(R.id.title)
        val description : TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RSSFeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.rss_feed_item, parent, false)
        return RSSFeedViewHolder(view)
    }

    override fun getItemCount(): Int = rssFeedList.size

    override fun onBindViewHolder(holder: RSSFeedViewHolder, position: Int) {
        holder.date.text = rssFeedList[position].pubDate
        holder.title.text = rssFeedList[position].title
        holder.description.text = rssFeedList[position].description.substring(0,43) + "..."
        holder.article_entry.setOnClickListener {
            val intent = Intent(it.context, NewsArticleActivity::class.java)
            intent.putExtra("Item", Item(rssFeedList[position].title, rssFeedList[position].link, rssFeedList[position].description, rssFeedList[position].pubDate))
            it.context.startActivity(intent)
        }
    }
}