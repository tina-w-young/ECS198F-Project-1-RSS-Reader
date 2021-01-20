package com.android.example.rssreader

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.example.rssreader.model.Item
import kotlinx.android.synthetic.main.activity_news_article.*
import org.w3c.dom.Text


class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)

        // TODO PHASE 2

        val article_date : TextView = findViewById<TextView>(R.id.article_date)
        val article_title: TextView = findViewById<TextView>(R.id.article_title)
        val article_description: TextView = findViewById<TextView>(R.id.article_description)

        val item : Item = intent.getParcelableExtra<Item>("Item")!!
        article_date.text = item.pubDate
        article_title.text = item.title
        article_description.text = item.description

        findViewById<ImageButton>(R.id.article_link).setOnClickListener{
            val webpage: Uri = Uri.parse(item.link)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }


    }
}