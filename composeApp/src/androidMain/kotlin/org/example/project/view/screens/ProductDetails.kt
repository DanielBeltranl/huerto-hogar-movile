package org.example.project.view.screens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.example.project.repository.productos
import org.example.project.view.screens.composables.Details

@Serializable
data class ProductDetails(val id: Int?)

@Serializable
object ProductDetailsScreen

@Composable
fun ProductDetailsScreen(id: Int?, navController: NavController) {
    Scaffold {
        Details( products = productos, id = id, modifier = Modifier.padding(it), navController = navController)
    }
}