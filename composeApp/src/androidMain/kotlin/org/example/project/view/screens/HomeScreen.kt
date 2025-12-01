package org.example.project.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.example.project.repository.Product
import org.example.project.view.screens.composables.HomeGrid

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavController,
    products: List<Product>
) {
    HomeGrid(
        products = products,
        onProductClick = onProductClick
    )
}