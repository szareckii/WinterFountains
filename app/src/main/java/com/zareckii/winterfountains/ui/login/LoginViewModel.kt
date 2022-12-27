package com.zareckii.winterfountains.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zareckii.winterfountains.data.login.LoginParams
import com.zareckii.winterfountains.data.Result
import com.zareckii.winterfountains.domain.login.LoginUseCase
import com.zareckii.winterfountains.domain.user.GetUserFirstTokenUseCase
import com.zareckii.winterfountains.ui.login.model.LoginAction
import com.zareckii.winterfountains.ui.login.model.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUserFirstTokenUseCase: GetUserFirstTokenUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState.asStateFlow()

    fun registration() {

        _viewState.update { it.copy(isLoading = true) }

        _viewState.update {
            it.copy(
                loginAction = LoginAction.GetTokenSuccess,
                isError = true,
                isLoading = false
            )
        }

        viewModelScope.launch {
            val param = LoginParams(
                name = _viewState.value.name,
                login = _viewState.value.login,
                password = _viewState.value.password,
            )
            val resultRegistration = loginUseCase(param)

            if (resultRegistration is Result.Success) {
                Log.e("stas", "Success - $resultRegistration")
                val resultToken = getUserFirstTokenUseCase(param)
                if (resultToken is Result.Success) {
                    Log.e("stas", "Token Success - $resultToken")
                    _viewState.update {
                        it.copy(
                            loginAction = LoginAction.GetTokenSuccess,
                            isError = true,
                            isLoading = false
                        )
                    }
                } else {
                    Log.e("stas", "Token Error - $resultToken")
                    _viewState.update { it.copy(isError = true, isLoading = false) }
                }
            } else {
                Log.e("stas", "Error - $resultRegistration")
                _viewState.update { it.copy(isError = true, isLoading = false) }
            }
        }
    }

    fun onValueNameChange(value: String) = _viewState.update { it.copy(name = value) }

    fun onValueLoginChange(value: String) = _viewState.update { it.copy(login = value) }

    fun onValuePasswordChange(value: String) = _viewState.update { it.copy(password = value) }

    fun onChangePasswordVisible() =
        _viewState.update { it.copy(passwordVisible = !_viewState.value.passwordVisible) }

}