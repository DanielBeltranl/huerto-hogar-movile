package org.example.project

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.example.project.model.Producto
import org.example.project.repository.ProductoRepository
import org.example.project.view.screens.HomeScreen
import org.example.project.view.screens.LoginScreen
import org.example.project.view.screens.ProductDetailsScreen
import org.example.project.view.screens.ProfileScreen

@Serializable
data class ProductDetails(val id: String?)

@Serializable
object LoginScreen
@Serializable
object HomeScreenRoute

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        val productoRepository = remember { ProductoRepository() }

        var productsState by remember { mutableStateOf<List<Producto>>(emptyList()) }
        var isLoading by remember { mutableStateOf(true) }
        var isError by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            val result = productoRepository.getListaProductos()
            result.fold(
                onSuccess = { listaProductos ->
                    productsState = listaProductos ?: emptyList()
                    isLoading = false
                },
                onFailure = {
                    Log.e("App.kt", "Error al cargar productos", it)
                    isLoading = false
                    isError = true
                }
            )
        }

        NavHost(navController, startDestination = LoginScreen) {
            composable<LoginScreen> {
                LoginScreen(
                    onLoggedIn = { navController.navigate(HomeScreenRoute) }
                )
            }

            composable<HomeScreenRoute> {
                when {
                    isLoading -> {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                    }
                    isError -> {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text("Error al cargar productos", color = MaterialTheme.colorScheme.error)
                        }
                    }
                    else -> {
                        MainScreen(navController, productsState)
                    }
                }
            }

            composable<ProductDetails> { backStackEntry ->
                val productDetails: ProductDetails = backStackEntry.toRoute()
                ProductDetailsScreen(
                    navController = navController,
                    id = productDetails.id,
                )
            }
        }
    }
}

@Composable
fun MainScreen(navController: androidx.navigation.NavController, products: List<Producto>) {
    val mainNavController = rememberNavController()
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                        mainNavController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Profile",
                            tint = if (selectedItem == 1) Color.Blue else Color.Gray
                        )
                    },
                    label = { Text("Perfil") },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        mainNavController.navigate("profile") {
                            launchSingleTop = true
                            popUpTo("profile") { inclusive = true }
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = mainNavController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                selectedItem = 0
                HomeScreen(
                    navController = navController,
                    onProductClick = { productId ->
                        navController.navigate(ProductDetails(id = productId))
                    },
                    products = products
                )
            }
            composable("profile") {
                selectedItem = 1
                ProfileScreen()
            }
        }
    }
}