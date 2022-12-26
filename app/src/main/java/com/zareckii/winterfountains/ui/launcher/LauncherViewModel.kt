package com.zareckii.winterfountains.ui.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zareckii.winterfountains.data.successOr
import com.zareckii.winterfountains.domain.login.GetUserTokenUseCase
import com.zareckii.winterfountains.domain.user.GetUserUseCase
import com.zareckii.winterfountains.navigation.NavigationTree
import com.zareckii.winterfountains.ui.launcher.model.LauncherViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val userTokenUseCase: GetUserTokenUseCase,
    private val userUseCase: GetUserUseCase,
) : ViewModel() {

    private val _viewState = MutableStateFlow(LauncherViewState())
    val viewState: StateFlow<LauncherViewState> = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            val userToken = userTokenUseCase(Unit).successOr("")
            if (userToken.isEmpty()) {
                _viewState.update { it.copy(initScreen = NavigationTree.LOGIN) }
            } else {
                val user = userUseCase(Unit).successOr(null)

            }
        }
    }
}