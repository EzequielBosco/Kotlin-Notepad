package com.example.practicaparcialappmoviles

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practicaparcialappmoviles.ui.theme.PracticaParcialAppMovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            PracticaParcialAppMovilesTheme {
                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ){
                    composable("lista") { ListaDeNotasView(navController) }
                    composable("nueva") { App(navController, "Nueva Nota") }
                }
            }
        }
    }
}
