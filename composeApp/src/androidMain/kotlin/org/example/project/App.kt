package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
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
        NavHost(navController, startDestination = LoginScreen){
            composable<LoginScreen>{ LoginScreen(
                onLoggedIn = {navController.navigate(HomeScreen)}
            )}
            composable<HomeScreen>{
                HomeScreen(
                    navController = navController,
                    onProductClick = { productId ->
                    navController.navigate(ProductDetails(id = productId))

                })

            }
            composable<ProductDetails> { backStackEntry ->
                val productDetails: ProductDetails = backStackEntry.toRoute()
                ProductDetailsScreen(
                    navController = navController,
                    id = productDetails.id

                )

            }

            composable<ProfileScreen> {
                ProfileScreen()
            }

        }


    }
}