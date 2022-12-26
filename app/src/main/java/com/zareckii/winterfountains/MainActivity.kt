package com.zareckii.winterfountains

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zareckii.winterfountains.navigation.BottomNavItem
import com.zareckii.winterfountains.navigation.BottomNavigationScreen
import com.zareckii.winterfountains.navigation.NavigationGraph
import com.zareckii.winterfountains.ui.theme.WinterFountainsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WinterFountainsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenView()
                }
            }
        }
    }
}

@Composable
fun MainScreenView() {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        bottomBar = {
            if (currentRoute(navController) in (listOf(
                    BottomNavItem.Home.screen_route,
                    BottomNavItem.Route.screen_route,
                    BottomNavItem.Settings.screen_route
                ))
            )
                BottomNavigationScreen(navController = navController)
        },
        scaffoldState = scaffoldState
    ) { padding ->
        NavigationGraph(
            modifier = Modifier.padding(paddingValues = padding),
            navController = navController,
        )
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.e("stas", "route = ${navBackStackEntry?.destination?.route}")
    return navBackStackEntry?.destination?.route
}