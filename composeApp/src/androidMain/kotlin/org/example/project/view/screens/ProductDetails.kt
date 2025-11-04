package org.example.project.view.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.Serializable
import org.example.project.repository.productos
import org.example.project.view.screens.composables.Details

@Serializable
data class ProductDetails(val id: Int)


@Composable
fun ProductDetailsScreen(id: Int) {
    Scaffold {
        Details(products = productos, id = id, modifier = Modifier.padding(it))
    }
}