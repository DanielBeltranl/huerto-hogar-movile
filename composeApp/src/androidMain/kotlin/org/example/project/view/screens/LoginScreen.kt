package org.example.project.view.screens

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.size.Size
import kotlinx.serialization.Serializable
import org.example.project.viewmodel.LoginViewModel

@Serializable
object LoginScreen
@Composable
fun LoginScreen(onLoggedIn: () -> Unit, viewModel: LoginViewModel = viewModel()) {

    LaunchedEffect(viewModel.state.loggedIn){
        if(viewModel.state.loggedIn)
            onLoggedIn()
    }

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val state = viewModel.state
    val mensaje = when{
        state.loggedIn -> "Log in exitoso"
        state.error != null -> state.error
        else -> null
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://media1.tenor.com/m/_ug_rmdmfhIAAAAd/vegetables.gif")
                .size(Size.ORIGINAL)
                .build(),
            contentDescription = "Fondo animado",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),


            ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                label = { Text("Correo") },
                value = user,
                onValueChange = { user = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next

                )
            )

            var passwordVisible by remember { mutableStateOf(false) }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                label = { Text("contraseña") },
                value = password,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done

                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar Contraseña"
                        )
                    }
                }

            )

            Button(
                onClick = { viewModel.login(user, password) },
                shape = RectangleShape
            ) {
                Text("Iniciar Sesion")
            }

            if (mensaje != null) {
                Text(text = mensaje)
            }

        }
    }

}