package com.example.kotlin_portfolio.screens.login

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text("Login SCREEN")
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
