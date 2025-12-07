    package com.example.OurApp.Screens.navigation

    import android.annotation.SuppressLint
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.Icon
    import androidx.compose.material3.NavigationBar
    import androidx.compose.material3.NavigationBarItem
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Modifier
    import androidx.navigation.NavBackStackEntry
    import androidx.navigation.NavDestination
    import androidx.navigation.NavDestination.Companion.hierarchy
    import androidx.navigation.NavGraph.Companion.findStartDestination
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.currentBackStackEntryAsState
    import androidx.navigation.compose.rememberNavController
    import com.example.OurApp.Screens.HomeScreen
    import com.example.OurApp.Screens.ProfileScreen
    import com.example.OurApp.Screens.SearchScreen

    @SuppressLint("NewApi")
    @Composable
    fun AppNav(){
        val navController = rememberNavController()
         val selectedItem = remember { mutableStateOf<NavItems?>(null) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry : NavBackStackEntry? by navController.currentBackStackEntryAsState()
                    val currentDestination : NavDestination? = navBackStackEntry?.destination

                    listOfNavItems.forEach { navItem: NavItems ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                            onClick = {
                                         selectedItem.value = navItem  // Update selected item
                                      navController.navigate(navItem.route){
                                          popUpTo(navController.graph.findStartDestination().id){
                                              saveState = true
                                          }
                                          launchSingleTop = true
                                          restoreState = true
                                      }
                                      },
                            icon = {
                                Icon(
                                    imageVector = if (selectedItem.value == navItem) navItem.selectedIcon else navItem.unselectedIcon,
                                    contentDescription = null  // Include this for accessibility
                                )
                            },
                            label = {
                                Text(text = navItem.title)

                            }
                        )
                    }
                }
            }
        ) {paddingValues ->
            NavHost(navController = navController, startDestination = Screens.HomeScreen.name,
            modifier = Modifier
                .padding(paddingValues)){
                composable(route =  Screens.HomeScreen.name){
                    HomeScreen()
                }

                composable(route =  Screens.ProfileScreen.name){
                    ProfileScreen()
                }

                composable(route =  Screens.SearchScreen.name){
                    SearchScreen()
                }
            }
        }
    }


