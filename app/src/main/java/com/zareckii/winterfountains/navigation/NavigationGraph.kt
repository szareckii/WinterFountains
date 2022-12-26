package com.zareckii.winterfountains.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zareckii.winterfountains.ui.HomeScreen
import com.zareckii.winterfountains.ui.RouteScreen
import com.zareckii.winterfountains.ui.SettingsScreen
import com.zareckii.winterfountains.ui.launcher.LauncherScreen
import com.zareckii.winterfountains.ui.login.LoginScreen

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationTree.LAUNCHER.name) {

        composable(NavigationTree.LAUNCHER.name) {
            LauncherScreen(navController = navController)
        }

        composable(NavigationTree.LOGIN.name) {
            LoginScreen(navController = navController)
        }

        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Route.screen_route) {
            RouteScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
            SettingsScreen()
        }
    }
}
