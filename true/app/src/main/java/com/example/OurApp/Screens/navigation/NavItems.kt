package com.example.OurApp.Screens.navigation



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val route: String   )

val listOfNavItems =  listOf(
    NavItems(
        title = "Device Info",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        route = Screens.HomeScreen.name
    ),
    NavItems(
        title = "Speed Test",
        selectedIcon = Icons.Filled.PlayArrow,
        unselectedIcon = Icons.Outlined.PlayArrow,
        route = Screens.ProfileScreen.name
    ),
    NavItems(
        title = "Search ",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        route = Screens.SearchScreen.name
    )
 )



