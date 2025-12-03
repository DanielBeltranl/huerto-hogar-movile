package org.example.project.view.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.example.project.repository.ProductoRepository
import org.example.project.view.screens.composables.Details
import org.example.project.view.screens.composables.LoadingScreen
import org.example.project.view.screens.transiciones.ErrorScreen
import org.example.project.viewmodel.HomeViewModel
import org.example.project.viewmodel.UiState
import org.example.project.viewmodel.ViewModelFactory

@Serializable
data class ProductDetails(val id: String?) // Corregido: El ID debe ser String (id_fruta)

@Serializable
object ProductDetailsScreen

@Composable
fun ProductDetailsScreen(
    id: String?,
    navController: NavController
) {
    val repository = remember { ProductoRepository() }
    val factory = ViewModelFactory(repository)
    val homeViewModel: HomeViewModel = viewModel(factory = factory)

    val uiState by homeViewModel.uiState.collectAsState()

    Scaffold { paddingValues ->

        when (uiState) {

            is UiState.Loading -> {
                LoadingScreen()
            }

            is UiState.Error -> {
                ErrorScreen(
                    message = "Producto no encontrado.",
                    onRetryOrBack = { navController.popBackStack() },
                    buttonText = "Volver a la lista"
                )
            }

            is UiState.Success -> {
                val products = (uiState as UiState.Success).productos

                val selectedProduct = products?.find { it.id_fruta == id }

                if (selectedProduct != null) {
                    Details(
                        product = selectedProduct,
                        onBackClick = { navController.popBackStack() },
                        modifier = Modifier.padding(paddingValues)
                    )
                } else {

                    ErrorScreen(
                        message = "Producto no encontrado.",
                        onRetryOrBack = { navController.popBackStack() },
                        buttonText = "Volver a la lista"
                    )
                }
            }
        }
    }
}