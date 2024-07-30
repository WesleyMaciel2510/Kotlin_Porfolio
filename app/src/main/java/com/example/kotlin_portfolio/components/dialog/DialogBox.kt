package com.example.kotlin_portfolio.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle

@Composable
fun DialogWithImage(
    modifier: Modifier = Modifier,
    Title: String,
    Message: String,
    onDismissRequest: () -> Unit,
    onConfirmation: (() -> Unit)? = null,
    icon: ImageVector,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            onDismissRequest = { onDismissRequest() },
            icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "Info Icon",
                    modifier = Modifier.size(44.dp)
                )
            },
            title = { Text(text = Title) },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = Message,
                        style = TextStyle(fontSize = 18.sp),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss")
                }
            },
            confirmButton = {
                onConfirmation?.let { onConfirm ->
                    Button(onClick = { onConfirm() }) {
                        Text("Confirm")
                    }
                }
            }
        )
    }
}
