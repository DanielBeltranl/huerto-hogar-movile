package org.example.project.view.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.example.project.R
import org.example.project.model.Producto // Importamos tu nuevo data class Producto

@Composable
fun HomeGrid(
    products: List<Producto>,
    modifier: Modifier = Modifier,
    onProductClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(products, key = { _, producto -> producto.id_fruta }) { _, producto ->
            Column(
                modifier = modifier
                    .padding(5.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable { onProductClick(producto.id_fruta) }
            ) {
                val imageRes = when (producto.id_fruta) {
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
                    contentDescription = producto.nombre,
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = producto.nombre,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // Debes definir el composable AddButton() si no existe
                    AddButton()
                }

                Text(
                    text = "$${producto.precio}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp).padding(horizontal = 8.dp)
                )
            }
        }
    }
}