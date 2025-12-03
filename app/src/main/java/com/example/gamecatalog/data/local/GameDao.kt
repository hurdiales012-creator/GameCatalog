package com.example.gamecatalog.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games ORDER BY id ASC")
    fun getAllGames(): Flow<List<GameDbEntity>>

    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getGameById(id: Int): GameDbEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: GameDbEntity)

    @Update
    suspend fun updateGame(game: GameDbEntity)

    @Delete
    suspend fun deleteGame(game: GameDbEntity)
}
