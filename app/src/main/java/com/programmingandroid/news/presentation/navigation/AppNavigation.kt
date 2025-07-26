package com.programmingandroid.news.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.programmingandroid.news.core.util.NavigationRoutes
import com.programmingandroid.news.data.model.remote.BottomNavItem
import com.programmingandroid.news.presentation.screens.home.HomeScreen

val bottomNavItems =
    listOf(
        BottomNavItem(
            name = "Home",
            route = NavigationRoutes.HOME_ROUTE,
            icon = Icons.Default.Home,
        ),
        BottomNavItem(
            name = "Search",
            route = NavigationRoutes.SEARCH_ROUTE,
            icon = Icons.Default.Search,
        ),
        BottomNavItem(
            name = "Favorites",
            route = NavigationRoutes.FAVORITES_ROUTE,
            icon = Icons.Default.Favorite,
        ),
        BottomNavItem(
            name = "Profile",
            route = NavigationRoutes.PROFILE_ROUTE,
            icon = Icons.Default.Person,
        ),
    )

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.HOME_ROUTE,
        modifier = modifier,
    ) {
        composable(NavigationRoutes.HOME_ROUTE) {
            HomeScreen()
        }
        composable(NavigationRoutes.SEARCH_ROUTE) {
//            SearchScreen()
        }
        composable(NavigationRoutes.FAVORITES_ROUTE) {
//            FavoritesScreen()
        }
        composable(NavigationRoutes.NOTIFICATIONS_ROUTE) {
//            NotificationsScreen()
        }
        composable(NavigationRoutes.PROFILE_ROUTE) {
//            ProfileScreen()
        }
    }
}
