package com.example.gamecatalog.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamecatalog.data.local.GameDbEntity
import com.example.gamecatalog.ui.theme.*
import com.example.gamecatalog.ui.viewmodel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditGameScreen(
    viewModel: GameViewModel,
    navController: NavController
) {
    // 1. RECUPERAR DATOS: Vemos si hay un juego pendiente de editar en el ViewModel
    val gameToEdit = viewModel.gameToEdit

    // 2. INICIALIZAR CAMPOS:
    // Usamos 'remember(gameToEdit)' para asegurar que si cambia el juego, los campos se actualicen.
    // Si 'gameToEdit' existe, usamos sus datos. Si es null, ponemos texto vacío "".
    var name by remember(gameToEdit) { mutableStateOf(gameToEdit?.name ?: "") }
    var description by remember(gameToEdit) { mutableStateOf(gameToEdit?.description ?: "") }
    var platforms by remember(gameToEdit) { mutableStateOf(gameToEdit?.platforms ?: "") }
    var comment by remember(gameToEdit) { mutableStateOf(gameToEdit?.comment ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                // Título cambia dinámicamente
                title = { Text(if (gameToEdit != null) "Editar Juego" else "Nuevo Juego", color = TextWhite) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás", tint = TextWhite)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkBackground)
            )
        },
        containerColor = DarkBackground
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurface),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        // Subtítulo también cambia
                        text = if (gameToEdit != null) "EDITAR DETALLES" else "DETALLES DEL JUEGO",
                        style = MaterialTheme.typography.titleMedium,
                        color = PrimaryNeon,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )

                    Spacer(Modifier.height(16.dp))

                    GamerTextField(value = name, onValueChange = { name = it }, label = "Nombre del juego")
                    Spacer(Modifier.height(12.dp))
                    GamerTextField(value = description, onValueChange = { description = it }, label = "Descripción", singleLine = false)
                    Spacer(Modifier.height(12.dp))
                    GamerTextField(value = platforms, onValueChange = { platforms = it }, label = "Plataformas (PC, PS5...)")
                    Spacer(Modifier.height(12.dp))
                    GamerTextField(value = comment, onValueChange = { comment = it }, label = "Comentario personal")

                    Spacer(Modifier.height(24.dp))

                    GamerButton(
                        // Botón cambia de texto
                        text = if (gameToEdit != null) "GUARDAR CAMBIOS" else "AGREGAR A BIBLIOTECA",
                        onClick = {
                            if (name.isBlank()) return@GamerButton

                            if (gameToEdit != null) {
                                // --- MODO EDICIÓN ---
                                // Usamos .copy() para mantener el ID y estado de favorito, solo cambiamos textos
                                val updatedGame = gameToEdit.copy(
                                    name = name,
                                    description = description,
                                    platforms = platforms,
                                    comment = comment
                                )
                                viewModel.updateGame(updatedGame)
                            } else {
                                // --- MODO CREACIÓN ---
                                val newGame = GameDbEntity(
                                    name = name,
                                    description = description,
                                    platforms = platforms,
                                    comment = comment,
                                    dateAdded = "Hoy",
                                    imageResId = 0,
                                    isFavorite = false // Por defecto no es favorito
                                )
                                viewModel.addGame(newGame)
                            }

                            // Limpiamos la variable temporal y volvemos
                            viewModel.gameToEdit = null
                            navController.popBackStack()
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}