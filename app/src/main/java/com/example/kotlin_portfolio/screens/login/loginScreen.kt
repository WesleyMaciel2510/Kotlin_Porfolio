package com.example.kotlin_portfolio.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.Alignment
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_portfolio.R
import com.example.kotlin_portfolio.components.LottieAnimationView
import com.example.kotlin_portfolio.components.dialog.DialogWithImage
import com.example.kotlin_portfolio.screens.login.logic.LoginLogic
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun LoginScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    loginLogic: LoginLogic = viewModel()
) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(color = LightColorScheme.background)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontSize = 27.sp,
                color = LightColorScheme.outline,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = {
                    Text(
                        text = "Username",
                        color = LightColorScheme.outline
                    )
                        },
                modifier = Modifier
                    .width(300.dp)
                    .padding(bottom = 20.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(
                    text = "Password",
                    color = LightColorScheme.outline)},
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisibility)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = image,
                            contentDescription = null,
                            tint = LightColorScheme.outline
                        )
                    }
                },
                modifier = Modifier
                    .width(300.dp)
                    .padding(bottom = 20.dp)
            )

            if (!loading) {
                Button(
                    onClick = {
                        if (userName.isNotEmpty() && password.isNotEmpty()) {
                            loading = true
                            loginLogic.handleLogin(userName, password) { result ->
                                loading = false
                                if (result) {
                                    navController.navigate("home") {
                                        // Clear the back stack to prevent returning to the login screen
                                        popUpTo("login") { inclusive = true }
                                    }
                                } else {
                                    showDialog = true
                                }
                            }
                        } else {
                            showDialog = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50),
                    ),
                    modifier = Modifier
                        .width(200.dp)
                ) {
                    Text(text = "Login", color = Color(0XFFFFFFFF))
                }
            } else {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    LottieAnimationView(
                        modifier = Modifier.fillMaxSize(),
                        animationName = R.raw.loading_white,
                        looping = true
                    )
                }
            }
        }

        if (showDialog) {
            DialogWithImage(
                title = "Login Error",
                message = "Check your credentials and try again.",
                onDismissRequest = { showDialog = false },
                icon = Icons.Default.Info,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        LoginScreen(navController = navController)
    }
}
