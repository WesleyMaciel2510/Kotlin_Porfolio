package com.example.kotlin_portfolio.screens.newScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.screens.home.HomeScreen
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme

@Composable
fun NewScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewComponent() {
    val navController = rememberNavController()
    Kotlin_PortfolioTheme {
        NewScreen(navController = navController)
    }
}
