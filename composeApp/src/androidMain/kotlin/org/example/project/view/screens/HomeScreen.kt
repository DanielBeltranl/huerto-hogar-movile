package org.example.project.view.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import org.example.project.repository.productos
import org.example.project.view.screens.composables.HomeGrid

@Serializable
object HomeScreen

@Composable
fun HomeScreen(onProductClick: (Int) -> Unit){

    Scaffold (
        modifier = Modifier.statusBarsPadding().
        padding(5.dp)
    ) {padding ->
        HomeGrid(
            products = productos, 
            modifier = Modifier.padding(padding),
            onProductClick = onProductClick
        )
    }

}