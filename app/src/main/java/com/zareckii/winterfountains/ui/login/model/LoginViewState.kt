package com.zareckii.winterfountains.ui.login.model

sealed class LoginAction {
    object GetTokenSuccess : LoginAction()
    object None : LoginAction()
}


data class LoginViewState(
    val loginAction: LoginAction = LoginAction.None,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val name: String = "",
    val login: String = "",
    val password: String = "",
    val passwordVisible:  Boolean = false,
)
