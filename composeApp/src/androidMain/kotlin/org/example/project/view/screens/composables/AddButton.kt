package org.example.project.view.screens.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddButton (modifier: Modifier = Modifier) {
    IconButton(onClick = {}) {
        Icon(imageVector = Icons.Default.AddShoppingCart, contentDescription = "Carro de compras")
    }
}