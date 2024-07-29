package com.example.kotlin_portfolio.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun NewScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Your component content goes here
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewComponent() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        NewScreen(navController = navController)
    }
    Kotlin_PortfolioTheme {
        HomeScreen(navController = navController)
    }
}
