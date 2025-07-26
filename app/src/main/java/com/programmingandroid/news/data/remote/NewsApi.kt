package com.programmingandroid.news.data.remote

import com.programmingandroid.news.data.model.remote.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String? = null,
        @Query("from") fromDate: String? = null,
        @Query("to") toDate: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") pageSize: Int = 20,
    ): NewsResponse

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String? = "us",
        @Query("from") fromDate: String? = null,
    ): NewsResponse

    // Get Headlines from sources
    // Sources: Default,business,entertainment,general,health,science,sports,technology
    @GET("top-headlines/sources")
    suspend fun getHeadlinesFromSources(
        @Query("country") country: String? = "us",
        @Query("category") category: String? = "",
    ): NewsResponse
}
