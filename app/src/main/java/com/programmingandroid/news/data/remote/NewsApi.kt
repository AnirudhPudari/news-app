/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    suspend fun getTopHeadlines(@Query("country") country: String? = "us", @Query("from") fromDate: String? = null): NewsResponse

    // Get Headlines from sources
    // Sources: Default,business,entertainment,general,health,science,sports,technology
    @GET("top-headlines/sources")
    suspend fun getHeadlinesFromSources(@Query("country") country: String? = "us", @Query("category") category: String? = ""): NewsResponse
}
