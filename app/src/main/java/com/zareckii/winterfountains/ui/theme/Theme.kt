package com.zareckii.winterfountains.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun WinterFountainsTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides lightPalette,
        LocalTypographyProvider provides typography,
        content = content,
    )
}

object AppTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypographyProvider.current

}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default colors provided")
}

val LocalTypographyProvider = staticCompositionLocalOf<Typography> {
    error("No default typography provided")
}
