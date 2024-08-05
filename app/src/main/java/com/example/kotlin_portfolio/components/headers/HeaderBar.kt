package com.example.kotlin_portfolio.components.headers
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.kotlin_portfolio.ui.theme.Kotlin_PortfolioTheme
import com.example.kotlin_portfolio.ui.theme.LightColorScheme

@Composable
fun HeaderBar(
    modifier: Modifier = Modifier,
    label: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = LightColorScheme.outline)
            .padding(horizontal = 7.dp, vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { /* Handle menu icon click */ },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White

                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Box with search bar and border
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(color = LightColorScheme.outline)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                    //.padding(horizontal = 7.dp, vertical = 20.dp)
                ) {
                    Text(
                        text = label,
                        style = TextStyle(
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightColorScheme.background
                        ),
                        modifier = Modifier.padding(start = 15.dp)
                    )       
                }
            }
        }
    }
}

@OptIn(UnstableApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewHeaderBar() {
    Kotlin_PortfolioTheme {
        val searchText = remember { mutableStateOf(TextFieldValue("")) }
        HeaderBar(
            label = "Home"
        )
    }
}

