package com.android.example.rssreader

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
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
        val DateList: List<String> = item.pubDate.split(" ")
        article_date.text = DateList[2]+ " " + DateList[1] + ", " + DateList[3] + " - " + DateList[4].substring(0,5)
        article_title.text = item.title
        article_description.text = item.description

        findViewById<Button>(R.id.article_link).setOnClickListener{
            val webpage: Uri = Uri.parse(item.link)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val fab: View = findViewById(R.id.article_link2)
        fab.setOnClickListener { view ->
            val webpage: Uri = Uri.parse(item.link)
              val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}