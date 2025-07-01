package com.programmingandroid.news.data.repository

import com.programmingandroid.news.data.model.remote.NewsResponse

interface NewsRepository {

    suspend fun getEverythingNews(
        query: String? = null,
        fromDate: String? = null,
        toDate: String? = null,
        sortBy: String? = null,
        pageSize: Int = 20
    ): Result<NewsResponse>

    suspend fun getTopHeadlines(
        country: String = "us",
        fromDate: String? = null
    ): Result<NewsResponse>

    suspend fun getHeadlinesFromSources(
        country: String = "us",
        category: String = ""
    ): Result<NewsResponse>
}