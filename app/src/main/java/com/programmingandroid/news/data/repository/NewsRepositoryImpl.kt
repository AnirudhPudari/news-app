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
import com.programmingandroid.news.data.remote.NewsApi
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl
@Inject
constructor(private val newsApi: NewsApi) : NewsRepository {
    override suspend fun getEverythingNews(
        query: String?,
        fromDate: String?,
        toDate: String?,
        sortBy: String?,
        pageSize: Int,
    ): Flow<Result<NewsResponse>> {
        return flow {
        }
    }

    override suspend fun getTopHeadlines(country: String, fromDate: String?): Flow<Result<NewsResponse>> {
        return flow {
        }
    }

    override suspend fun getHeadlinesFromSources(country: String, category: String): Flow<Result<NewsResponse>> {
        return flow {
        }
    }
}
