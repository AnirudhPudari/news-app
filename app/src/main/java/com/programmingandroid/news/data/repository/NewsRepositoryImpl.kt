package com.programmingandroid.news.data.repository

import com.programmingandroid.news.data.model.remote.NewsResponse
import com.programmingandroid.news.data.remote.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl
    @Inject
    constructor(
        private val newsApi: NewsApi,
    ) : NewsRepository {
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

        override suspend fun getTopHeadlines(
            country: String,
            fromDate: String?,
        ): Flow<Result<NewsResponse>> {
            return flow {
            }
        }

        override suspend fun getHeadlinesFromSources(
            country: String,
            category: String,
        ): Flow<Result<NewsResponse>> {
            return flow {
            }
        }
    }
