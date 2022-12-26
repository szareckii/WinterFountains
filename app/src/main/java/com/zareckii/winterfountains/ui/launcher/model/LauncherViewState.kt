package com.zareckii.winterfountains.ui.launcher.model

import com.zareckii.winterfountains.navigation.NavigationTree

data class LauncherViewState(
    val initScreen: NavigationTree = NavigationTree.LOGIN,
)
