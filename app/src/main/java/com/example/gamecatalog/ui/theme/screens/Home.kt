package com.example.gamecatalog.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamecatalog.ui.viewmodel.GameViewModel

@Composable
fun HomeScreen(
    viewModel: GameViewModel = viewModel()
) {
    val games = viewModel.games.collectAsState()

    GameListScreen(games = games.value)
}
