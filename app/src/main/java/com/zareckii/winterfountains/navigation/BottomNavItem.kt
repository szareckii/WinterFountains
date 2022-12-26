package com.zareckii.winterfountains.navigation

import com.zareckii.winterfountains.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Home: BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object Route: BottomNavItem("Route", R.drawable.ic_baseline_map_24, "route")
    object Settings: BottomNavItem("Settings", R.drawable.ic_baseline_settings_24, "settings")
}