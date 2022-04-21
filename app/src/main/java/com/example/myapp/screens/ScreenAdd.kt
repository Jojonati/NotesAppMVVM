package com.example.myapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapp.navigation.NavRoute

@Composable
fun ScreenAdd(navController: NavHostController) {
    var title by remember {
        mutableStateOf("")
    }
    var subtitle by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add new note",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )


            OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text(text = "Note title") })
            OutlinedTextField(value = subtitle, onValueChange = { subtitle = it }, label = { Text(
                text = "Note subtitle"
            ) })
            Button(
                onClick = { navController.navigate(NavRoute.MainScreen.route) },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Add note")
            }
        }
    }
}