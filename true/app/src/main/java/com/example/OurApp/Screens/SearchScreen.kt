package com.example.OurApp.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.OurApp.R

@Preview
@Composable
fun SearchScreen() {
    DockedSearchBarM3()
    SearchBarM3()

}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBarM3()
    {

        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        val searchHistory = listOf("Android", "Kotlin", "Compose", "Material Design", "GPT-4")

        SearchBar( modifier = Modifier.fillMaxWidth(),
            query = query,
            onQueryChange = { query = it },
            onSearch = { newQuery ->
                println("Performing search on query: $newQuery")
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(text = "Type to Search ")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            },
        ) {
            searchHistory.takeLast(3).forEach { item ->
                ListItem(
                    modifier = Modifier.clickable { query = item },
                    headlineContent = { Text(text = item) },
                    leadingContent = {
                        Icon(
                            painter = painterResource(R.drawable.sc_history),
                            contentDescription = "null"
                        )
                    }
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DockedSearchBarM3()
    {
        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        val searchHistory = listOf("Android", "Kotlin", "Compose", "Material Design", "GPT-4")

        DockedSearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { newQuery ->
                println("Favourite $newQuery")
            },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(text = "tt")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "null")
            },
        ) {
            searchHistory.takeLast(8).forEach { item ->
                ListItem(
                    modifier = Modifier.clickable { query = item },
                    headlineContent = { Text(text = item) },
                    leadingContent = {
                        Icon(
                            painter = painterResource(R.drawable.sc_history),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }



