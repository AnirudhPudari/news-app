package com.programmingandroid.news.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(
    val route: String,
    val label: String,
    val icon: ImageVector? = null,
    val content: @Composable () -> Unit
)
