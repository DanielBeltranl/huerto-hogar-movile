package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.view.screens.HomeScreen
import org.example.project.view.screens.LoginScreen
import org.example.project.view.screens.ProductDetails
import org.example.project.view.screens.ProductDetailsScreen

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
                HomeScreen(onProductClick = { productId ->
                    navController.navigate(ProductDetails(id = productId))
                })
            }
            composable<ProductDetails> { backStackEntry ->
                val productDetails: ProductDetails = backStackEntry.toRoute()
                ProductDetailsScreen(id = productDetails.id)
            }
        }


    }
}