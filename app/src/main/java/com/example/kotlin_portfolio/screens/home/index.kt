package com.example.kotlin_portfolio.screens.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.components.headers.HeaderBar
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme
import fetchAirbnbPrices
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier,  context: Context) {
    val scope = rememberCoroutineScope()
    var apiResult by remember { mutableStateOf<String?>(null) }

    Column() {
        HeaderBar(label = "Home")

        Button(onClick = {
            scope.launch {
                apiResult = fetchAirbnbPrices(context)
            }
        }) {
            Text(text = "Fetch Airbnb Prices")
        }

        apiResult?.let {
            Text(text = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    Kotlin_PortfolioTheme {
        HomeScreen(navController = navController,  context = context)
    }
}
