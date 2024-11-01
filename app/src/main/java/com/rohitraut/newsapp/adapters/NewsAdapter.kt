package com.rohitraut.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rohitraut.newsapp.R
import com.rohitraut.newsapp.models.Article


class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    lateinit var articleImage: ImageView
    lateinit var articleSource: TextView
    lateinit var articleTitle: TextView
    lateinit var articleDescription: TextView
    lateinit var articleDateTime: TextView


    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override  fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean
        {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.item_news,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]


        articleImage = holder.itemView.findViewById(R.id.articleImage)
        articleSource = holder.itemView.findViewById(R.id.articleSource)
        articleTitle = holder.itemView.findViewById(R.id.articleTitle)
        articleDescription = holder.itemView.findViewById(R.id.articleDescription)
        articleDateTime = holder.itemView.findViewById(R.id.articleDateTime)


        holder.itemView.apply{
            Glide.with(this).load(article.urlToImage).into(articleImage)
            articleTitle.text = article.title ?: "Title not available"  // Safe handling for title
            articleSource.text = article.source?.name ?: "Source not available"  // Safe handling for source
            articleDescription.text = article.description ?: "Description not available"  // Safe handling for description
            articleDateTime.text = article.publishedAt ?: "Date not available"  // Safe handling for date


            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }

        }

    }
    fun setOnItemClickListener(listener: (Article) -> Unit){
         onItemClickListener = listener
    }

}