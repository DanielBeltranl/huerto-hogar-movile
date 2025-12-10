package org.example.project.view.screens

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable
import org.example.project.view.viewmodel.ProfileViewModel

@Serializable
object ProfileScreen

@Composable
fun ProfileScreen(profileViewModel: ProfileViewModel = viewModel()) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val savedUser by remember { mutableStateOf(sharedPref.getString("saved_user", "No guardado")) }

    val castMember = profileViewModel.castMember

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Perfil", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        castMember?.character?.image?.medium?.let {
            AsyncImage(
                model = it,
                contentDescription = "Foto de ${castMember.character.name}",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        castMember?.character?.name?.let {
            Text(it, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text("Usuario: $savedUser", fontSize = 16.sp)
    }
}
