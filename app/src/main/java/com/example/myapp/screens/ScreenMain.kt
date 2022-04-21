package com.example.myapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapp.navigation.NavRoute

@Composable
fun ScreenMain(navController: NavHostController) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate(NavRoute.AddScreen.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "", tint = Color.White)
        }
    }) {
        Column() {

            ItemCard(title = "Note 1 TITLE", subtitle = "Note 1 SUBTITLE", navController = navController)
            ItemCard(title = "Note 2 TITLE", subtitle = "Note 2 SUBTITLE", navController = navController)
            ItemCard(title = "Note 3 TITLE", subtitle = "Note 3 SUBTITLE", navController = navController)
            ItemCard(title = "Note 4 TITLE", subtitle = "Note 4 SUBTITLE", navController = navController)
            ItemCard(title = "Note 5 TITLE", subtitle = "Note 5 SUBTITLE", navController = navController)
        }
    }
}

@Composable
fun ItemCard(title: String, subtitle: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable { navController.navigate(NavRoute.NoteScreen.route) },
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle)
        }
    }
}
