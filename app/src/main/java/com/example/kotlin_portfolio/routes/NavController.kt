package com.example.kotlin_portfolio.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_portfolio.screens.forgotPassword.ForgotPasswordScreen
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.screens.login.LoginScreen
import com.example.kotlin_portfolio.screens.profile.ProfileScreen
import com.example.kotlin_portfolio.screens.signUp.SignUpScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    isAuthenticated: Boolean,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated) "home" else "login",
        modifier = modifier
    ) {
        //if (isAuthenticated) {
            composable("home") {
                HomeScreen(navController = navController/*, context = context*/)
            }
            composable("profile") {
                ProfileScreen(navController = navController)
            }
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
