package com.example.kotlin_portfolio

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.routes.AppNavigation
import com.example.kotlin_portfolio.screens.login.logic.LoginLogic
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun App() {
    val navController = rememberNavController()
    val authViewModel: LoginLogic = viewModel()

    // Collect the authentication state as a State
    val isAuthenticated by authViewModel.isAuthenticated.collectAsState()
    Log.d("APP", "isAuthenticated = $isAuthenticated")

    Scaffold(
        bottomBar = {
            if (isAuthenticated) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            isAuthenticated = isAuthenticated,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = LightColorScheme.background)
        )
    }
}

