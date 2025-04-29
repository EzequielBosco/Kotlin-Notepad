package com.example.practicaparcialappmoviles

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
            var listaNotas by rememberSaveable { mutableStateOf(listOf<Nota>()) }
            var contadorId by rememberSaveable { mutableStateOf(1) }
            val agregarNota: (String, String) -> Unit = { titulo, texto ->
                val nuevaNota = Nota(id = contadorId, titulo = titulo, texto = texto)
                listaNotas = listaNotas + nuevaNota
                contadorId++
            }

            PracticaParcialAppMovilesTheme {
                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ){
                    composable("lista") {
                        ListaDeNotasView(
                            navController,
                            listaNotas
                        )
                    }
                    composable("nueva") {
                        App(navController) { titulo, texto ->
                            agregarNota(titulo, texto)
                        }
                    }
                    composable("detalle/{id}") { backStack ->
                        val id = backStack.arguments?.getString("id")?.toIntOrNull()
                        id?.let {
                            val nota = listaNotas.find { it.id == id }
                            nota?.let {
                                DetalleNotaView(navController, it)
                            }
                        }
                    }
                }
            }
        }
    }
}
