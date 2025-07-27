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

package com.programmingandroid.news.data.repository

import com.programmingandroid.news.data.model.remote.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getEverythingNews(
        query: String? = null,
        fromDate: String? = null,
        toDate: String? = null,
        sortBy: String? = null,
        pageSize: Int = 20,
    ): Flow<Result<NewsResponse>>

    suspend fun getTopHeadlines(country: String = "us", fromDate: String? = null): Flow<Result<NewsResponse>>

    suspend fun getHeadlinesFromSources(country: String = "us", category: String = ""): Flow<Result<NewsResponse>>
}
