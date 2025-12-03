package com.example.gamecatalog.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Fondos Oscuros
val DarkBackground = Color(0xFF0F172A) // Azul noche muy oscuro
val CardSurface = Color(0xFF1E293B)    // Gris azulado para tarjetas
val InputSurface = Color(0xFF334155)   // Fondo para inputs

// Acentos Neón
val PrimaryNeon = Color(0xFF6366F1)    // Índigo vibrante
val SecondaryNeon = Color(0xFFEC4899)  // Rosa neón
val TertiaryNeon = Color(0xFF00BFFF)   // Azul eléctrico (Cyan)

// Texto
val TextWhite = Color(0xFFF8FAFC)
val TextGray = Color(0xFF94A3B8)

// Gradientes
val GamerGradient = Brush.horizontalGradient(
    colors = listOf(PrimaryNeon, SecondaryNeon)
)