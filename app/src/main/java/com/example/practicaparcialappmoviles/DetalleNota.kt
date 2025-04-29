package com.example.practicaparcialappmoviles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practicaparcialappmoviles.ui.theme.PracticaParcialAppMovilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleNotaView(
    navController: NavController,
    nota: Nota,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de nota") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                               .padding(16.dp)
        ) {
            Text("Título: ${nota.titulo}", style = MaterialTheme.typography.titleLarge)
            Text("Contenido: ${nota.texto}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val nota = Nota(
        id = 1,
        titulo = "Titulo ejemplo",
        texto = "Texto ejemplo"
    )
    PracticaParcialAppMovilesTheme{
        DetalleNotaView(
            rememberNavController(),
            nota
        )
    }
}