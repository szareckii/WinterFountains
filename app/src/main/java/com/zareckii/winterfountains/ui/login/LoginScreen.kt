package com.zareckii.winterfountains.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zareckii.winterfountains.R
import com.zareckii.winterfountains.navigation.NavigationTree
import com.zareckii.winterfountains.ui.components.ButtonWithText
import com.zareckii.winterfountains.ui.components.WTextField
import com.zareckii.winterfountains.ui.login.model.LoginAction
import com.zareckii.winterfountains.ui.login.model.LoginViewState
import com.zareckii.winterfountains.ui.theme.AppTheme

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {

    val viewState: LoginViewState by viewModel.viewState.collectAsState()

    val maxLetterName = 10
    val maxLetterLogin = 10
    val maxLetterPassword = 10

    val focusRequesterName = remember { FocusRequester() }
    val focusRequesterLogin = remember { FocusRequester() }
    val focusRequesterPassword = remember { FocusRequester() }

    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) { focusRequesterName.requestFocus() }

    with(viewState) {
        Scaffold(backgroundColor = AppTheme.colors.primaryBackground) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = stringResource(R.string.finder_fountains),
                    textAlign = TextAlign.Center,
                    color = AppTheme.colors.primaryTextColor,
                    fontSize = 28.sp
                )
                Spacer(modifier = Modifier.height(32.dp))

                WTextField(
                    modifier = Modifier.focusRequester(focusRequesterName),
                    value = name,
                    label = stringResource(R.string.name_label),
                    placeholder = stringResource(R.string.name_label),
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_account_box),
                            contentDescription = null,
                        )
                    },
                    onValueChange = { value ->
                        if (value.length <= maxLetterName) {
                            val text = value.filter { it.isLetter() || it.isWhitespace() }
                            viewModel.onValueNameChange(text)
                        }
                    },
                    isError = name.length >= maxLetterName,
                    errorMessage = if (name.length >= maxLetterName) stringResource(R.string.too_much_letters) else "",
                    keyboardActions = KeyboardActions(onDone = { focusRequesterLogin.requestFocus() }),
                )
                Spacer(modifier = Modifier.height(16.dp))
                WTextField(
                    modifier = Modifier.focusRequester(focusRequesterLogin),
                    value = login,
                    label = stringResource(R.string.login_label),
                    placeholder = stringResource(R.string.login_label),
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_account_box),
                            contentDescription = null,
                        )
                    },
                    onValueChange = { value ->
                        if (value.length <= maxLetterLogin) {
                            val text = value.filter { it.isLetter() || it.isWhitespace() }
                            viewModel.onValueLoginChange(text)
                        }
                    },
                    isError = login.length >= maxLetterLogin,
                    errorMessage = if (login.length >= maxLetterLogin) stringResource(R.string.too_much_letters) else "",
                    keyboardActions = KeyboardActions(onDone = { focusRequesterPassword.requestFocus() }),
                )
                Spacer(modifier = Modifier.height(16.dp))
                WTextField(
                    modifier = Modifier.focusRequester(focusRequesterPassword),
                    value = password,
                    label = stringResource(R.string.password_label),
                    placeholder = stringResource(R.string.password_label),
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_key),
                            contentDescription = null,
                        )
                    },
                    onValueChange = { value ->
                        if (value.length <= maxLetterPassword) {
                            val text = value.filter { it.isLetter() || it.isWhitespace() }
                            viewModel.onValuePasswordChange(text)
                        }
                    },
                    isError = password.length >= maxLetterPassword,
                    errorMessage = if (password.length >= maxLetterPassword) stringResource(R.string.too_much_letters) else "",
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff
                        val description = if (passwordVisible) "Hide password" else "Show password"
                        IconButton(onClick = { viewModel.onChangePasswordVisible() }) {
                            Icon(imageVector = image, description)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier.weight(1F))
                Spacer(modifier = Modifier.height(16.dp))
                ButtonWithText(
                    onClick = {
                        viewModel.registration()
                        focusManager.clearFocus()
                    },
                    text = stringResource(R.string.registration_label),
                    enabled = name.isNotEmpty() &&
                            login.isNotEmpty() &&
                            password.isNotEmpty() &&
                            name.length < maxLetterName &&
                            login.length < maxLetterLogin &&
                            password.length < maxLetterPassword
                )
            }
        }

        LaunchedEffect(key1 = loginAction) {
            when (viewState.loginAction) {
                is LoginAction.GetTokenSuccess -> {
                    navController.navigate(NavigationTree.HOME.name) {
                        popUpTo(NavigationTree.LOGIN.name) { inclusive = true }
                    }
                }
                else -> {}
            }
        }
    }
}
