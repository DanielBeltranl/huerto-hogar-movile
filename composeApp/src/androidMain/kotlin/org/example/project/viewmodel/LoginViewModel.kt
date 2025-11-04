package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    class UiState(
        val loggedIn: Boolean = false,
        val error : String? = null
    )

    fun login(user: String, password: String) {
        state = when {
            !user.contains("@") -> UiState(error = "El usuario no es valido")
            password.length<8 -> UiState(error = "La contraseña no es valida")
            else -> UiState(loggedIn = true, error = null)
        }
    }




}