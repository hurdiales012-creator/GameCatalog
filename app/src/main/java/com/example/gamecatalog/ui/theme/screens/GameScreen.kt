package com.example.gamecatalog.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.gamecatalog.ui.theme.DarkBackground
import com.example.gamecatalog.ui.theme.PrimaryNeon
import com.example.gamecatalog.ui.theme.TextWhite
import com.example.gamecatalog.ui.theme.screens.Screen
import com.example.gamecatalog.ui.viewmodel.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel,
    navController: NavController
) {
    // 1. Obtenemos la lista de juegos actualizada
    val games by viewModel.games.collectAsState()
    val context = LocalContext.current

    Scaffold(
        // Botón flotante para ir a "Nuevo Juego"
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // IMPORTANTE: Limpiamos la variable de edición para que el formulario salga vacío
                    viewModel.gameToEdit = null
                    navController.navigate(Screen.AddGame.route)
                },
                containerColor = PrimaryNeon,
                contentColor = TextWhite
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Juego")
            }
        },
        containerColor = DarkBackground
    ) { paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {

            // 2. Mostramos la lista
            GameListScreen(
                games = games,

                // Acción al eliminar
                onDeleteClick = { game ->
                    viewModel.deleteGame(game)
                    Toast.makeText(context, "Juego eliminado", Toast.LENGTH_SHORT).show()
                },

                // Acción al dar LIKE/DISLIKE
                onFavoriteClick = { game ->
                    viewModel.toggleFavorite(game)
                    Toast.makeText(context, "Juego añadido a favorito", Toast.LENGTH_SHORT).show()
                },

                // Acción al EDITAR
                onEditClick = { game ->
                    // 1. Guardamos el juego que queremos editar en el ViewModel
                    viewModel.gameToEdit = game
                    // 2. Navegamos a la misma pantalla de formulario
                    navController.navigate(Screen.AddGame.route)
                }
            )
        }
    }
}