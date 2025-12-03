package org.example.project.view.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.serialization.Serializable

@Serializable
object ProfileScreen

@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val savedUser by remember { mutableStateOf(sharedPref.getString("saved_user", "No guardado")) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Perfil", fontSize = 24.sp)
        Text("Usuario: $savedUser", fontSize = 16.sp)
    }
}