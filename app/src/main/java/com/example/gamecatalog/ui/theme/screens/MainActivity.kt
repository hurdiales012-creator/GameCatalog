package com.example.gamecatalog.ui.theme.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamecatalog.ui.screens.AddEditGameScreen
import com.example.gamecatalog.ui.screens.FavoritesScreen
import com.example.gamecatalog.ui.screens.GameScreen
import com.example.gamecatalog.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = DarkBackground, modifier = Modifier.fillMaxSize()) {
                MainNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // --- CORRECCIÓN IMPORTANTE ---
    // Instanciamos el ViewModel AQUÍ, para que sea el MISMO para todas las pantallas.
    val sharedViewModel: com.example.gamecatalog.ui.viewmodel.GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    val menuItems = listOf(Screen.Home, Screen.Favorites, Screen.Profile)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = CardSurface,
                drawerContentColor = TextWhite
            ) {
                Spacer(Modifier.height(24.dp))
                Text(
                    "GAME CATALOG",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = PrimaryNeon
                )
                Divider(color = InputSurface)
                Spacer(Modifier.height(12.dp))

                menuItems.forEach { screen ->
                    NavigationDrawerItem(
                        icon = { Icon(screen.icon, contentDescription = null, tint = TextGray) },
                        label = { Text(stringResource(screen.resourceId), color = TextWhite) },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(screen.route)
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("CATÁLOGO", color = TextWhite) },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = DarkBackground,
                        titleContentColor = TextWhite,
                        navigationIconContentColor = TextWhite
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = null, tint = TextWhite)
                        }
                    }
                )
            },
            containerColor = DarkBackground
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(padding)
            ) {
                // RUTA HOME: Usamos 'sharedViewModel'
                composable(Screen.Home.route) {
                    GameScreen(sharedViewModel, navController)
                }

                // RUTA AGREGAR/EDITAR: Usamos EL MISMO 'sharedViewModel'
                composable(Screen.AddGame.route) {
                    AddEditGameScreen(sharedViewModel, navController)
                }

                // FAVORITOS: También le pasamos el compartido para que detecte los cambios
                composable(Screen.Favorites.route) {
                    FavoritesScreen(sharedViewModel)
                }

                composable(Screen.Profile.route) { ProfileScreen() }
            }
        }
    }
}