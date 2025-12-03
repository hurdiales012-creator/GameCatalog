package com.example.gamecatalog.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamecatalog.ui.theme.DarkBackground
import com.example.gamecatalog.ui.theme.TextGray
import com.example.gamecatalog.ui.viewmodel.GameViewModel

@Composable
fun FavoritesScreen(
    viewModel: GameViewModel = viewModel()
) {
    // 1. Obtenemos TODOS los juegos
    val games = viewModel.games.collectAsState()

    // 2. FILTRO CLAVE: Solo mostramos los que tienen isFavorite = true
    val favoriteGames = games.value.filter { it.isFavorite }

    if (favoriteGames.isEmpty()) {
        // Pantalla vacía si no hay favoritos
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No tienes favoritos aún",
                color = TextGray,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    } else {
        // Reutilizamos la lista, pero solo con los filtrados
        GameListScreen(
            games = favoriteGames,

            // Permitimos quitar el corazón desde aquí
            onFavoriteClick = { game ->
                viewModel.toggleFavorite(game)
            },

            // Opcional: Si quieres permitir borrar desde favoritos
            onDeleteClick = { game ->
                viewModel.deleteGame(game)
            }
        )
    }
}