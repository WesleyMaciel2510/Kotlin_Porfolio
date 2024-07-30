package com.example.kotlin_portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.navigation.AppNavigation
import com.example.kotlin_portfolio.screens.login.logic.LoginLogic
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun App() {
    val navController = rememberNavController()
    val authViewModel: LoginLogic = viewModel()

    Scaffold(
        bottomBar = {
            if (authViewModel.isAuthenticated.value) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            isAuthenticated = authViewModel.isAuthenticated.value,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = LightColorScheme.background)
        )
    }
}
