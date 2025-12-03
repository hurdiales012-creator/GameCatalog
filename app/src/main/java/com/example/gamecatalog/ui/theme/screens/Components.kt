package com.example.gamecatalog.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamecatalog.ui.theme.*

// 1. Botón con gradiente (Sin cambios, pero asegurando imports)
@Composable
fun GamerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Gray
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (enabled) GamerGradient else SolidColor(Color.DarkGray)
                )
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text.uppercase(),
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }
    }
}

// 2. Chip de Plataforma (Corrección de imports y Surface)
@Composable
fun PlatformChip(platformName: String) {
    Surface(
        color = InputSurface.copy(alpha = 0.5f),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, PrimaryNeon.copy(alpha = 0.3f)),
        modifier = Modifier.padding(end = 4.dp, bottom = 4.dp)
    ) {
        Text(
            text = platformName.trim().uppercase(),
            color = TertiaryNeon,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            fontSize = 10.sp
        )
    }
}

// 3. Campo de texto (Corrección del error de OutlinedTextFieldDefaults)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = TextGray) },
        modifier = modifier.fillMaxWidth(),
        singleLine = singleLine,
        // CORRECCIÓN AQUÍ:
        // En Material 3 actualizado, se usa OutlinedTextFieldDefaults.colors()
        // en lugar de TextFieldDefaults.outlinedTextFieldColors()
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryNeon,
            unfocusedBorderColor = InputSurface,
            focusedContainerColor = CardSurface,
            unfocusedContainerColor = CardSurface,
            focusedTextColor = TextWhite,
            unfocusedTextColor = TextWhite,
            cursorColor = SecondaryNeon,
            // Aseguramos que el label no se pierda
            focusedLabelColor = PrimaryNeon,
            unfocusedLabelColor = TextGray
        ),
        shape = RoundedCornerShape(12.dp)
    )
}