package org.example.project.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.example.project.model.Producto
import org.example.project.view.screens.composables.HomeGrid

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    onProductClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavController,
    products: List<Producto>
) {
    HomeGrid(
        products = products,
        onProductClick = onProductClick
    )
}