package com.example.gamecatalog.ui.screens
import androidx.annotation.DrawableRes

data class Game(
    val id: Int,
    val name: String,
    val description: String,
    val platforms: List<String>,
    @DrawableRes val imageResId: Int,
    val dateAdded: String,
    val comment: String
)
