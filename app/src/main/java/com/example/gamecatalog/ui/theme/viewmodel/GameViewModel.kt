package com.example.gamecatalog.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamecatalog.data.GameRepository
import com.example.gamecatalog.data.local.GameDatabase
import com.example.gamecatalog.data.local.GameDbEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GameViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = GameDatabase.getDatabase(app).gameDao()
    private val repo = GameRepository(dao)


    var gameToEdit: GameDbEntity? = null

    val games = repo.games.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addGame(game: GameDbEntity) = viewModelScope.launch {
        repo.addGame(game)
    }

    fun updateGame(game: GameDbEntity) = viewModelScope.launch {
        repo.updateGame(game)
    }

    fun deleteGame(game: GameDbEntity) = viewModelScope.launch {
        repo.deleteGame(game)
    }

    fun toggleFavorite(game: GameDbEntity) = viewModelScope.launch {
        val updatedGame = game.copy(isFavorite = !game.isFavorite)
        repo.updateGame(updatedGame)
    }
}