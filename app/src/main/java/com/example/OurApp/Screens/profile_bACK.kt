package com.example.OurApp.Screens

/*
* package com.example.OurApp.Screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
//
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //ElevatedCardExample()
       // FilledCardExample()
        OutlinedCardExample()
        //CustomCard { Log.d("custom card", "hello word") }

 }
}
//     //[START android_compose_components_customary]
//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun CustomCard(event: () -> Unit) {
//        Card(
//            border = BorderStroke(1.dp, Color.Black),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surfaceVariant,
//            ),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = 4.dp
//            ),
//            enabled = true,
//            modifier = Modifier.padding(16.dp),
//            onClick = event,
//            shape = RoundedCornerShape(8.dp),
//        ) {
//            Text(
//                text = "Custom card that uses the Card composable. Tap me to say hello world.",
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxSize()
//            )
//        }
//    }


//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            "Speed test",
//            fontFamily = FontFamily.SansSerif,
//            fontSize = 24.sp
//
//        )
//    }

@Preview
// [START android_compose_components_outlined card]
@Composable
fun OutlinedCardExample() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            "Outlined", Modifier.run { padding(16.dp) },
            textAlign = TextAlign.Center,
        )
    }
}
*////