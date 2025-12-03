package com.example.gamecatalog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val platforms: String,
    val imageResId: Int = 0,
    val dateAdded: String,
    val comment: String,
    val isFavorite: Boolean = false
)