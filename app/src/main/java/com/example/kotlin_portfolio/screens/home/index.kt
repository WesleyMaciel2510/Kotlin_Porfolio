package com.example.kotlin_portfolio.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.kotlin_portfolio.model.EmotionDetectionResponse
import com.example.kotlin_portfolio.services.fetchEmotionDetection
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var emotionDetectionResults by remember { mutableStateOf<List<EmotionDetectionResponse>?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()

    // Fetch emotion detection results
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                emotionDetectionResults = fetchEmotionDetection(context)
                isLoading = false
            } catch (e: Exception) {
                errorMessage = "Failed to fetch data"
                isLoading = false
            }
        }
    }

    Column(modifier = modifier.padding(16.dp)) {
        if (isLoading) {
            Text("Loading...")
        } else if (errorMessage != null) {
            Text("Error: $errorMessage")
        } else {
            emotionDetectionResults?.let { results ->
                results.forEach { result ->
                    Text("Emotion: ${result.emotion.value}, Probability: ${result.emotion.probability}")
                }
            } ?: Text("No data available")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    Kotlin_PortfolioTheme {
        HomeScreen(navController = navController)
    }
}
