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

package com.programmingandroid.news.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingandroid.news.core.util.NavigationRoutes.FAVORITES_ROUTE
import com.programmingandroid.news.core.util.NavigationRoutes.HOME_ROUTE
import com.programmingandroid.news.core.util.NavigationRoutes.SEARCH_ROUTE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar(currentRoute: String?) {
    val title =
        when (currentRoute) {
            HOME_ROUTE -> "Latest News"
            SEARCH_ROUTE -> "Saved Articles"
            FAVORITES_ROUTE -> "Settings"
            else -> "News App"
        }

    TopAppBar(
        title = {
            Text(
                title,
                modifier =
                Modifier
                    .padding(start = 20.dp),
                style = MaterialTheme.typography.titleLarge,
            )
        },
    )
}

@Preview
@Composable
fun NewsTopBarPreview() {
    NewsTopBar("Latest News")
}
