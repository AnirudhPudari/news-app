package com.programmingandroid.news.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.programmingandroid.news.core.theme.NewsTheme
import com.programmingandroid.news.presentation.components.NewsTopBar
import com.programmingandroid.news.presentation.navigation.AppNavGraph
import com.programmingandroid.news.presentation.navigation.bottomNavItems

@Composable
fun NewsApp(modifier: Modifier = Modifier) {
    NewsTheme {
        val navController = rememberNavController()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        var selectedIndex = bottomNavItems.indexOfFirst { it.route == currentRoute }

        Scaffold(
            modifier = modifier,
            topBar = { NewsTopBar(currentRoute = currentRoute) },
            bottomBar = {
                NavigationBar(
                    windowInsets = NavigationBarDefaults.windowInsets,
                ) {
                    bottomNavItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.name) },
                            label = { Text(item.name) },
                            selected = selectedIndex == index,
                            onClick = {
                                navController.navigate(item.route)
                                selectedIndex = index
                            },
                        )
                    }
                }
            },
        ) { innerPadding ->
            AppNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Preview
@Composable
fun NewsAppPreview() {
    NewsApp()
}
