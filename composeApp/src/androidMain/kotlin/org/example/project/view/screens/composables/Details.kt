package org.example.project.view.screens.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable
import org.example.project.R
import org.example.project.repository.Product

@Serializable
object Details

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details( products: List<Product>, id: Int?, modifier: Modifier = Modifier, navController: NavController) {
    val product = products.find { it.id == id }

    Scaffold(
        topBar = {TopAppBar(
            title = {Text("Huerto Hogar")},
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = "atras")
                }

            }
        )

        },
        modifier = modifier) {
        Column(
            modifier = Modifier.padding(it)) {
            product?.let {
                val imageRes = when (it.code) {
                    "FR001" -> R.drawable.fr001
                    "FR002" -> R.drawable.fr002
                    "FR003" -> R.drawable.fr003
                    "VR001" -> R.drawable.vr001
                    "VR002" -> R.drawable.vr002
                    "VR003" -> R.drawable.vr003
                    "PO001" -> R.drawable.po001
                    "PO003" -> R.drawable.po003
                    "PL001" -> R.drawable.pl001
                    else -> R.drawable.ic_launcher_foreground
                }
                AsyncImage(
                    model = imageRes,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.name, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: $${it.price}", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Stock: ${it.stock}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

