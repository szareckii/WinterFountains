package com.zareckii.winterfountains.ui.theme

import androidx.compose.ui.graphics.Color


data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryTextColor: Color,
    val primaryAccentColor: Color,
    val disableBackground: Color,
    val disableContentBtnColor: Color,
    val secondaryTextColor: Color,
    val primaryTextInvertColor: Color,
    val warningColor: Color,

)

val lightPalette = Colors(
    primaryBackground = Color(0xFFFFFFFF),
    secondaryBackground = Color(0xFFFAFAFA),
    primaryTextColor = Color(0xFF607D8B),
    primaryAccentColor = Color(0xFF03A9F4),
    disableBackground = Color(0xFFEEEEEE),
    disableContentBtnColor = Color(0xFFBDBDBD),
    secondaryTextColor = Color(0xFFB0BEC5),
    primaryTextInvertColor = Color(0xFFFFFFFF),
    warningColor = Color(0xFFE40025),
)