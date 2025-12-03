package com.example.gamecatalog.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gamecatalog.ui.screens.GamerButton
import com.example.gamecatalog.ui.screens.GamerTextField
import com.example.gamecatalog.ui.theme.*

@Composable
fun ProfileScreen() {
    var email by remember { mutableStateOf("") }
    var stayConnected by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBackground)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        // Avatar Placeholder
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(CardSurface, CircleShape)
                .border(2.dp, PrimaryNeon, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = TextGray,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "PLAYER ONE",
            style = MaterialTheme.typography.headlineMedium,
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Gestiona tu cuenta y sincronización",
            style = MaterialTheme.typography.bodyMedium,
            color = TextGray
        )

        Spacer(modifier = Modifier.height(32.dp))

        GamerTextField(value = email, onValueChange = { email = it }, label = "Correo electrónico")

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = stayConnected,
                onCheckedChange = { stayConnected = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryNeon,
                    uncheckedColor = TextGray,
                    checkmarkColor = TextWhite
                )
            )
            Text("Mantener sesión iniciada", color = TextGray)
        }

        GamerButton(
            text = "INICIAR SESIÓN",
            onClick = { /* ... */ }
        )

        Spacer(Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(modifier = Modifier.weight(1f), color = InputSurface)
            Text(" O ", color = TextGray, modifier = Modifier.padding(horizontal = 8.dp))
            Divider(modifier = Modifier.weight(1f), color = InputSurface)
        }

        Spacer(Modifier.height(24.dp))

        SocialLoginButton(text = "Google", color = Color(0xFFDB4437))
        SocialLoginButton(text = "Discord", color = Color(0xFF5865F2))
        SocialLoginButton(text = "PlayStation Network", color = Color(0xFF00439C))
    }
}

@Composable
private fun SocialLoginButton(text: String, color: Color) {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .height(45.dp),
        colors = ButtonDefaults.buttonColors(containerColor = CardSurface),
        shape = MaterialTheme.shapes.small,
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.5f))
    ) {
        Text(text = "Continuar con $text", color = TextWhite)
    }
}