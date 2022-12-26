package com.zareckii.winterfountains.ui.launcher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.zareckii.winterfountains.navigation.NavigationTree
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
