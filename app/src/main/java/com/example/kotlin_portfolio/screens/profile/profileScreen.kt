package com.example.kotlin_portfolio.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.components.headers.HeaderBar
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun ProfileScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HeaderBar(label = "Profile")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        ProfileScreen(navController = navController)
    }
}