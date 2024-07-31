package com.example.kotlin_portfolio.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.screens.profile.ProfileScreen

@Composable
fun AuthNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") {
            HomeScreen(navController = navController, context = context)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
    }
}
