package com.programmingandroid.news.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programmingandroid.news.core.util.NavigationRoutes.FAVORITES_ROUTE
import com.programmingandroid.news.core.util.NavigationRoutes.HOME_ROUTE
import com.programmingandroid.news.core.util.NavigationRoutes.SEARCH_ROUTE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar(currentRoute: String?) {
    val title = when (currentRoute) {
        HOME_ROUTE -> "Latest News"
        SEARCH_ROUTE -> "Saved Articles"
        FAVORITES_ROUTE -> "Settings"
        else -> "News App"
    }

    TopAppBar(
        title = {
            Text(
                title,
                modifier = Modifier
                    .padding(start = 20.dp),
                style = MaterialTheme.typography.titleLarge,
            )
        })

    /*    Surface(
            color = Color(0xFF6200EE), // Background color
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "News App",
                    color = Color.White,
                )
            }
        }*/
}


@Preview
@Composable
fun NewsTopBarPreview() {
    NewsTopBar("Latest News")
}