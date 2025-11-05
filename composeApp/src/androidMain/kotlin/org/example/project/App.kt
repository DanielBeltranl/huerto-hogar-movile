package org.example.project

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.project.repository.productos
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.view.screens.HomeScreen
import org.example.project.view.screens.LoginScreen
import org.example.project.view.screens.ProductDetails
import org.example.project.view.screens.ProductDetailsScreen
import org.example.project.view.screens.ProfileScreen
import org.example.project.view.screens.composables.Details

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        var currentRoute by remember { mutableStateOf<String>("home") }

        NavHost(navController, startDestination = LoginScreen) {
            composable<LoginScreen> {
                LoginScreen(
                    onLoggedIn = { navController.navigate(HomeScreen){

                    } }
                )
            }

            composable<HomeScreen> {
                currentRoute = "home"
                MainScreen(navController)
            }

            composable<ProductDetails> { backStackEntry ->
                val productDetails: ProductDetails = backStackEntry.toRoute()
                ProductDetailsScreen(
                    navController = navController,
                    id = productDetails.id
                )
            }
        }
    }
}

@Composable
fun MainScreen(navController: androidx.navigation.NavController) {
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
                    }
                )
            }
            composable("profile") {
                selectedItem = 1
                ProfileScreen()
            }
        }
    }
}