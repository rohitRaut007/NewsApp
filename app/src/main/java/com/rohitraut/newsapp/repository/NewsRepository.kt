package com.rohitraut.newsapp.repository

import com.rohitraut.newsapp.api.RetrofitInstance
import com.rohitraut.newsapp.db.ArticleDatabase
import com.rohitraut.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines( countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleData().upsert(article)

    fun getFavouriteNews() = db.getArticleData().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleData().deleteArticles(article)
}
