package com.example.kotlin_portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.routes.AuthNavigation
import com.example.kotlin_portfolio.routes.AuthNavigation
import com.example.kotlin_portfolio.routes.NonAuthNavigation
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun App() {
    val navController = rememberNavController()
    val isAuthenticated = isUserAuthenticated()

    Scaffold(
        bottomBar = {
            if (isAuthenticated) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = LightColorScheme.background)
        ) {
            if (isAuthenticated) {
                AuthNavigation(navController = navController, modifier = Modifier.weight(1f))
            } else {
                NonAuthNavigation(navController = navController, modifier = Modifier.weight(1f))
            }
        }
    }
}

// Dummy authentication check
private fun isUserAuthenticated(): Boolean {
    // Replace this with your actual authentication logic
    return false
}
