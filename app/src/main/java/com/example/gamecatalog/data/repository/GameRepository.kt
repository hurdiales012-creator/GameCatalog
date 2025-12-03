package com.example.gamecatalog.data

import com.example.gamecatalog.data.local.GameDao
import com.example.gamecatalog.data.local.GameDbEntity
import kotlinx.coroutines.flow.Flow

class GameRepository(private val dao: GameDao) {

    val games: Flow<List<GameDbEntity>> = dao.getAllGames()

    suspend fun addGame(game: GameDbEntity) = dao.insertGame(game)

    suspend fun updateGame(game: GameDbEntity) = dao.updateGame(game)

    suspend fun deleteGame(game: GameDbEntity) = dao.deleteGame(game)
}
