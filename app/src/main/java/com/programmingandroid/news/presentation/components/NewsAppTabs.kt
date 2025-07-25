package com.programmingandroid.news.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsAppTabs(
    tabs: List<TabItem>,
    onTabSelected: (TabItem) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    ScrollableTabRow(
        containerColor = MaterialTheme.colorScheme.surface,
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            PrimaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                height = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
        },
        divider = {
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabItem ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                modifier = Modifier
                    .padding(horizontal = 0.dp)  // Reduced spacing between tabs
                    .height(48.dp),
                text = {
                    NewsCategoryChip(
                        text = tabItem.label,
                        selected = selectedTabIndex == index
                    )
                }
            )
        }
    }
}


@Preview
@Composable
fun NavigationTabPreview() {
    NewsAppTabs(tabs = newsTabs) { }
}

val newsTabs = listOf(
    TabItem(
        route = "all",
        label = "All",
        content = { }
    ),
    TabItem(
        route = "sports",
        label = "Sports",
        content = { }
    ),
    TabItem(
        route = "technology",
        label = "Technology",
        content = { }
    ),
    TabItem(
        route = "business",
        label = "Business",
        content = { }
    ),
    TabItem(
        route = "entertainment",
        label = "Entertainment",
        content = { }
    )
)

