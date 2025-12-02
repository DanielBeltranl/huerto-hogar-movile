package org.example.project.view.screens.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.example.project.R
import org.example.project.model.Producto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(

    product: Producto,

    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(product.nombre) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Atrás")
                    }
                }
            )
        },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {


            val imageRes = when (product.id_fruta) {
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
                contentDescription = product.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(vertical = 16.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = product.nombre,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Precio: $${product.precio}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.descripcion,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Stock Disponible: ${product.stock}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}