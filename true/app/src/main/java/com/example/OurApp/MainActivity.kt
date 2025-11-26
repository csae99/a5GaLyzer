package com.example.OurApp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.OurApp.Screens.Home
import com.example.OurApp.Screens.ProfileScreen
import com.example.OurApp.Screens.SearchScreen
import com.example.OurApp.Screens.navigation.AppNav
import com.example.OurApp.Screens.navigation.TopAppBarContent


class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                        OurAppTheme()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MainContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        // Add flexible Home content with weight
        Column(
            modifier = Modifier
              //  .weight(1f)
                .padding(paddingValues)
              //  .padding(vertical = 8.dp)
        ) {
            Home()
        }

        // Add Spacer to create some space between AppNav and content
        Spacer(modifier = Modifier.height(16.dp))

        ProfileScreen()

        SearchScreen()
    }
}

@Preview
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun OurAppTheme() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Add TopAppBar
        TopAppBarContent()

        // Add Spacer to create some space between TopAppBar and content
        Spacer(modifier = Modifier.height(16.dp))

        // Add MainContent inside Scaffold
        Scaffold(
            bottomBar = { AppNav() }
        ) { paddingValues ->
            MainContent(paddingValues)
        }
    }
}


//@Composable
//fun OurAppTheme() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//
//    ) {
//        // Add TopAppBar
//        TopAppBarContent()
//
//        // Add Spacer to create some space between TopAppBar and content
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Add AppNav
//        AppNav()
//
//        // Add Spacer to create some space between AppNav and content
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Add flexible Home content with weight
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(horizontal = 16.dp)
//        ) {
//            Home()
//        }
//
//        ProfileScreen()
//
//        SearchScreen()
//    }
//}
