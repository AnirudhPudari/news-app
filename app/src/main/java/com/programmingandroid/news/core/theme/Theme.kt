package com.programmingandroid.news.core.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme =
    darkColorScheme(
        primary = Color(0xFF90CAF9),
        onPrimary = Color(0xFF000000),
        primaryContainer = Color(0xFF1565C0),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFFFFB74D),
        onSecondary = Color(0xFF000000),
        background = Color(0xFF121212),
        onBackground = Color(0xFFFFFFFF),
        surface = Color(0xFF1E1E1E),
        onSurface = Color(0xFFFFFFFF),
        error = Color(0xFFF44336),
        onError = Color(0xFFFFFFFF),
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Color(0xFF1E88E5),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFF1565C0),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFFF57C00),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFE64A19),
        onSecondaryContainer = Color(0xFFFFFFFF),
        background = Color(0xFFF5F5F5),
        onBackground = Color(0xFF212121),
        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF212121),
        error = Color(0xFFD32F2F),
        onError = Color(0xFFFFFFFF),
    )

@Composable
fun NewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = NewsShapes,
        content = content,
    )
}
