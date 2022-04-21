package com.example.myapp.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.MainViewModel
import com.example.myapp.MainViewModelFactory
import com.example.myapp.navigation.NavRoute
import com.example.myapp.navigation.NotesNavHost
import com.example.myapp.utils.TYPE_DATABASE
import com.example.myapp.utils.TYPE_FIREBASE
import com.example.myapp.utils.TYPE_ROOM_DATABASE

@Composable
fun ScreenStart(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "What will we use?")
            
            Button(onClick = {
                navController.navigate(
                    route = NavRoute.MainScreen.route
                )
                mViewModel.initDatabase(TYPE_ROOM_DATABASE)
            }, modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)) {
                Text(text = "Room database")
            }

            Button(
                onClick = {
                    navController.navigate(route = NavRoute.MainScreen.route)
                    mViewModel.initDatabase(TYPE_FIREBASE)
                          },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Firebase database")
            }
        }
    }

}
