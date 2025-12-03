package com.example.gamecatalog.data.local

import com.example.gamecatalog.R

object SampleGames {

    val list = listOf(
        GameDbEntity(
            name = "Cyberpunk 2077",
            description = "Un RPG de acción y aventura de mundo abierto...",
            platforms = listOf("PC", "PS5", "Xbox Series X").joinToString(","),
            imageResId = R.drawable.game1,
            dateAdded = "10/11/2025",
            comment = "Un regreso increíble después de un lanzamiento difícil."
        ),
        GameDbEntity(
            name = "The Witcher 3",
            description = "Juegas como Geralt de Rivia...",
              platforms = listOf("PC", "PS4", "Xbox One", "Switch").joinToString(","),
            imageResId = R.drawable.game2,
            dateAdded = "05/10/2025",
            comment = ""
        ),
        GameDbEntity(
            name = "Elden Ring",
            description = "Un juego de rol de acción de fantasía...",
            platforms = listOf("PC", "PS5", "PS4", "Xbox").joinToString(","),
            imageResId = R.drawable.game3,
            dateAdded = "01/10/2023",
            comment = ""
        ),
        GameDbEntity(
            name = "Baldur's Gate 3",
            description = "Un RPG de nueva generación...",
            platforms = listOf("PC", "PS5", "Mac").joinToString(","),
            imageResId = R.drawable.game4,
            dateAdded = "12/5/2024",
            comment = "Obra maestra."
        ),
        GameDbEntity(
            name = "Red Dead Redemption 2",
            description = "Una historia épica...",
            platforms = listOf("PC", "PS4", "Xbox One").joinToString(","),
            imageResId = R.drawable.game5,
            dateAdded = "11/05/2023",
            comment = ""
        ),
        GameDbEntity(
            name = "God of War: Ragnarök",
            description = "Kratos y Atreus deben viajar...",
            platforms = listOf("PS5", "PS4").joinToString(","),
            imageResId = R.drawable.game6,
            dateAdded = "10/01/2024",
            comment = "¡niñooo!"
        ),
        GameDbEntity(
            name = "Valorant",
            description = "Tienes 13 rondas para atacar y defender tu lado con armas precisas...",
            platforms = listOf("PS5", "Xbox", "PC").joinToString(","),
            imageResId = R.drawable.game7,
            dateAdded = "2/5/2025",
            comment = "Sebas un valito o k"
        ),
        GameDbEntity(
            name = "Fortnite",
            description = "Fortnite es un videojuego de disparos en línea...",
            platforms = listOf("PS5", "Xbox", "PC", "Movil").joinToString(","),
            imageResId = R.drawable.game8,
            dateAdded = "11/11/2025",
            comment = "Saquen el fort"
        ),
        GameDbEntity(
            name = "Counter-Strike",
            description = "videojuego de disparos táctico multijugador en primera persona...",
            platforms = listOf("PS5", "PS4").joinToString(","),
            imageResId = R.drawable.game9,
            dateAdded = "10/10/2025",
            comment = ""
        ),
        GameDbEntity(
            name = "Minecraft",
            description = "Minecraft es un videojuego de mundo abierto...",
            platforms = listOf("PC", "Movil").joinToString(","),
            imageResId = R.drawable.game10,
            dateAdded = "1/11/2025",
            comment = "¡maicra!"
        ),
        GameDbEntity(
            name = "League of Legends",
            description = "League of Legends es un videojuego de estrategia en línea...",
            platforms = listOf("PC", "Movil").joinToString(","),
            imageResId = R.drawable.game11,
            dateAdded = "7/6/2025",
            comment = "zzzz"
        ),
        GameDbEntity(
            name = "Overwatch",
            description = "Overwatch es un videojuego de disparos en primera persona...",
            platforms = listOf("PC", "PS5", "Xbox").joinToString(","),
            imageResId = R.drawable.game12,
            dateAdded = "9/11/2011",
            comment = "mehh"
        ),
        GameDbEntity(
            name = "Grand Theft Auto V",
            description = "Grand Theft Auto V es un videojuego de acción-aventura...",
            platforms = listOf("PC", "PS4", "Xbox").joinToString(","),
            imageResId = R.drawable.game13,
            dateAdded = "3/04/2025",
            comment = ""
        ),
        GameDbEntity(
            name = "The Last of Us Part II",
            description = "The Last of Us Part II es un videojuego de acción-aventura...",
            platforms = listOf("PS5", "PS4", "Xbox", "PC").joinToString(","),
            imageResId = R.drawable.game14,
            dateAdded = "1/1/2025",
            comment = "Si ven las 1.7 hs jugadas, fueron solo de estar en el menú compilando shaders"
        ),
        GameDbEntity(
            name = "FIFA 26",
            description = "FIFA 23 es un videojuego de simulación de fútbol...",
            platforms = listOf("PC", "PS4", "Xbox").joinToString(","),
            imageResId = R.drawable.game15,
            dateAdded = "10/10/2025",
            comment = "lo mismo de siempre"
        ),
        GameDbEntity(
            name = "The Elder Scrolls V: Skyrim",
            description = "The Elder Scrolls V: Skyrim es un videojuego de rol de acción...",
            platforms = listOf("PC", "PS5", "Xbox").joinToString(","),
            imageResId = R.drawable.game16,
            dateAdded = "10/9/2025",
            comment = "Juego del año"
        ),
        GameDbEntity(
            name = "Assassin's Creed Valhalla",
            description = "Assassin's Creed Valhalla es un videojuego de acción-aventura...",
            platforms = listOf("PS5", "PS4", "Xbox").joinToString(","),
            imageResId = R.drawable.game17,
            dateAdded = "20/8/2025",
            comment = "Excelente ambientación y gráficos."
        ),
        GameDbEntity(
            name = "The Legend of Zelda: Breath of the Wild",
            description = "The Legend of Zelda: Breath of the Wild es un videojuego de aventuras...",
            platforms = listOf("Nintendo Switch").joinToString(","),
            imageResId = R.drawable.game18,
            dateAdded = "16/9/2025",
            comment = "Uno de los mejores juegos hechos por Nintendo."
        ),
        GameDbEntity(
            name = "Super Mario Odyssey",
            description = "Super Mario Odyssey es un videojuego de plataformas...",
            platforms = listOf("Nintendo Switch").joinToString(","),
            imageResId = R.drawable.game19,
            dateAdded = "27/9/2025",
            comment = "Maravillosa entrega de Super Mario."
        ),
        GameDbEntity(
            name = "Animal Crossing: New Horizons",
            description = "Animal Crossing: New Horizons es un videojuego de simulación de vida...",
            platforms = listOf("Nintendo Switch").joinToString(","),
            imageResId = R.drawable.game20,
            dateAdded = "20/9/2025",
            comment = "Divertido y creativo, ideal para niños."
        ),
        GameDbEntity(
            name = "PEAK",
            description = "Peak es un videojuego de escalada cooperativo...",
            platforms = listOf("PC").joinToString(","),
            imageResId = R.drawable.game21,
            dateAdded = "16/4/2025",
            comment = "Tremenda joya 20/10."
        ),
        GameDbEntity(
            name = "Resident Evil Village",
            description = "Resident Evil Village es un videojuego de horror...",
            platforms = listOf("PC", "PS5", "PS4", "Nintendo Switch", "iOS").joinToString(","),
            imageResId = R.drawable.game22,
            dateAdded = "18/7/2025",
            comment = "Juegazo absoluto."
        ),
        GameDbEntity(
            name = "R.E.P.O.",
            description = "Un juego de terror cooperativo en línea con hasta 6 jugadores",
            platforms = listOf("PC").joinToString(","),
            imageResId = R.drawable.game23,
            dateAdded = "29/10/2025",
            comment = "Buen juego para jugar con amigos."
        ),
        GameDbEntity(
            name = "Hollow Knight: Silksong",
            description = "Explora, lucha y sobrevive mientras asciendes a la cima...",
            platforms = listOf("PC").joinToString(","),
            imageResId = R.drawable.game24,
            dateAdded = "10/11/2025",
            comment = "Muy esperado por los fans."
        ),
        GameDbEntity(
            name = "Left 4 Dead",
            description = "Juego cooperativo de acción y terror...",
            platforms = listOf("Xbox360", "PC").joinToString(","),
            imageResId = R.drawable.game25,
            dateAdded = "16/8/2025",
            comment = "Clásico divertido con amigos."
        ),
        GameDbEntity(
            name = "The Forest",
            description = "Sobrevive contra mutantes caníbales en un bosque misterioso.",
            platforms = listOf("PC", "PS4").joinToString(","),
            imageResId = R.drawable.game26,
            dateAdded = "20/1/2025",
            comment = "Entretenido con amigos."
        )
    )
}