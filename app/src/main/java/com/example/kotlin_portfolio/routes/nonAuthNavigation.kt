package com.example.kotlin_portfolio.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_portfolio.screens.forgotPassword.ForgotPasswordScreen
import com.example.kotlin_portfolio.screens.login.LoginScreen
import com.example.kotlin_portfolio.screens.signUp.SignUpScreen

@Composable
fun NonAuthNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "login", modifier = modifier) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("signUp") {
            SignUpScreen(navController = navController)
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(navController = navController)
        }
    }
}
