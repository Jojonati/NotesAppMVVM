package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.screens.ScreenAdd
import com.example.myapp.screens.ScreenMain
import com.example.myapp.screens.ScreenNote
import com.example.myapp.screens.ScreenStart

sealed class NavRoute(val route: String) {
    object StartScreen: NavRoute("start_screen")
    object NoteScreen: NavRoute("note_screen")
    object AddScreen: NavRoute("add_screen")
    object MainScreen: NavRoute("main_screen")
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route){
        composable(NavRoute.StartScreen.route) {
            ScreenStart(navController = navController)
        }
        composable(NavRoute.NoteScreen.route) {
            ScreenNote(navController = navController)
        }
        composable(NavRoute.AddScreen.route) {
            ScreenAdd(navController = navController)
        }
        composable(NavRoute.MainScreen.route) {
            ScreenMain(navController = navController)
        }
    }
}





