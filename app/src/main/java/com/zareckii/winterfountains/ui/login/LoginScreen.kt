package com.zareckii.winterfountains.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.zareckii.winterfountains.R
import com.zareckii.winterfountains.navigation.NavigationTree
import com.zareckii.winterfountains.ui.login.model.LoginAction
import com.zareckii.winterfountains.ui.login.model.LoginViewState

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {

    val viewState: LoginViewState by viewModel.viewState.collectAsState()

    with(viewState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Winter fountains",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Log in",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "name",
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "login",
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "password",
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.login("login8", "password1", "name1")
                }
            ) {
                Text(text = "Registration")
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
}
