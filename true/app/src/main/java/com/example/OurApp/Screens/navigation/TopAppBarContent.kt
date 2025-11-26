package com.example.OurApp.Screens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBarContent()
    {
        TopAppBar( title = {
            // Center the title and align with the gear icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "5Galyzer",
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.weight(1f) // Expand title to fill available space
                )
                IconButton(onClick = { /* Handle settings click */ },
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        tint = Color.Black,
                        contentDescription = "Settings"

                    )
                }
            }
        },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary)
                    .padding(vertical = 14.dp)
       )

    }
