package dev.vladleesi.yac.system

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
actual fun isDarkThemeEnabled(): Boolean =
    isSystemInDarkTheme()