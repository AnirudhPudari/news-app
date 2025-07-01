package com.programmingandroid.news.data.model.remote

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)