package com.zareckii.winterfountains.ui.launcher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.zareckii.winterfountains.ui.launcher.model.LauncherViewState

@Composable
fun LauncherScreen(
    viewModel: LauncherViewModel = hiltViewModel(),
    navController: NavController
) {

    val viewState: LauncherViewState by viewModel.viewState.collectAsState()

    LaunchedEffect(viewState.initScreen) {
        navController.navigate(viewState.initScreen.name) {
            popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
//            popUpTo(NavigationTree.LAUNCHER.name) { inclusive = true }
        }
    }
}
