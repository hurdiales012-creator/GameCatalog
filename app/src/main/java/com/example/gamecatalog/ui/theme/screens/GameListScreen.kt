package com.example.gamecatalog.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.gamecatalog.data.local.GameDbEntity
import com.example.gamecatalog.ui.theme.*

@Composable
fun GameListScreen(
    games: List<GameDbEntity>,
    onEditClick: ((GameDbEntity) -> Unit)? = null,
    onDeleteClick: ((GameDbEntity) -> Unit)? = null,
    // Esta función se llama cuando tocas el corazón
    onFavoriteClick: ((GameDbEntity) -> Unit)? = null
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        items(games) { game ->
            GameCard(game, onEditClick, onDeleteClick, onFavoriteClick)
        }
    }
}

@Composable
fun GameCard(
    game: GameDbEntity,
    onEditClick: ((GameDbEntity) -> Unit)?,
    onDeleteClick: ((GameDbEntity) -> Unit)?,
    onFavoriteClick: ((GameDbEntity) -> Unit)?
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardSurface),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Column {
                // --- IMAGEN ---
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(CardSurface)
                ) {
                    if (game.imageResId != 0) {
                        Image(
                            painter = painterResource(id = game.imageResId),
                            contentDescription = game.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                                        startY = 100f
                                    )
                                )
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.linearGradient(
                                        listOf(PrimaryNeon.copy(alpha = 0.6f), Color.Transparent)
                                    )
                                )
                        )
                    }

                    Text(
                        text = game.name,
                        style = MaterialTheme.typography.headlineSmall,
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                            .padding(end = 40.dp)
                    )
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.wrapContentSize()) {
                        game.platforms.split(",").take(3).forEach { PlatformChip(it) }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = game.description,
                        color = TextGray,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    if (game.comment.isNotBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Nota: ${game.comment}",
                            color = SecondaryNeon,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    if (onEditClick != null && onDeleteClick != null) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Divider(color = InputSurface)
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { onEditClick(game) }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar", tint = TertiaryNeon)
                            }
                            IconButton(onClick = { onDeleteClick(game) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Red.copy(alpha = 0.7f))
                            }
                        }
                    }
                }
            }

            // --- BOTÓN DE CORAZÓN ---
            IconButton(
                onClick = {
                    // Al tocar, avisa al padre (GameScreen/FavoritosScreen) para que guarde el cambio
                    onFavoriteClick?.invoke(game)
                },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(Color.Black.copy(alpha = 0.4f), CircleShape)
            ) {
                Icon(
                    // Lógica visual: Si game.isFavorite es true -> Corazón Relleno
                    // Si es false -> Corazón Borde
                    imageVector = if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito",
                    // Color: Si es favorito -> Rosa Neón, si no -> Blanco
                    tint = if (game.isFavorite) SecondaryNeon else TextWhite
                )
            }
        }
    }
}