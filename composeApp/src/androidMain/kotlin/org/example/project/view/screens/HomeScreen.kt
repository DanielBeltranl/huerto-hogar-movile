package org.example.project.view.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import org.example.project.repository.productos
import org.example.project.view.screens.composables.HomeGrid

@Serializable
object HomeScreen

@Composable
fun HomeScreen(
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier, navController: NavController
){
    var selectedItem = remember { mutableStateOf(0) }

    Scaffold (
        modifier = modifier
            .statusBarsPadding()
            .padding(5.dp),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedItem.value == 0,
                    onClick = { navController.navigate(HomeScreen) }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = selectedItem.value == 2,
                    onClick = { navController.navigate(ProfileScreen)}
                )
            }
        }
    ) { padding ->
        HomeGrid(
            products = productos,
            modifier = Modifier.padding(padding),
            onProductClick = onProductClick
        )
    }
}