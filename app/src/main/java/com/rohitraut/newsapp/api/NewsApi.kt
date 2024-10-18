package com.rohitraut.newsapp.api

import com.rohitraut.newsapp.models.NewsResponse
import com.rohitraut.newsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi{


    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String,
        CountryCode: String = "in",

        @Query("page")
        pageNumber: Int = 1,

        @Query("apiKey") apiKey: String,
        ApiKey : String = API_KEY

    ):Response<NewsResponse>


    @GET("v2/everything")
    suspend fun SearchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsResponse>
}