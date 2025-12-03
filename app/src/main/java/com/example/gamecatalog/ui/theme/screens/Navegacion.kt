package com.example.gamecatalog.ui.theme.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gamecatalog.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Home : Screen("home", R.string.screen_home, Icons.Default.Home)
    object Favorites : Screen("favorites", R.string.screen_favoritos, Icons.Default.Favorite)
    object Profile : Screen("profile", R.string.screen_profile, Icons.Default.Person)

    // Nueva pantalla para Agregar/Editar (No necesita recurso de string para menú porque no sale en el drawer)
    object AddGame : Screen("add_game", R.string.screen_home, Icons.Default.Add)
}