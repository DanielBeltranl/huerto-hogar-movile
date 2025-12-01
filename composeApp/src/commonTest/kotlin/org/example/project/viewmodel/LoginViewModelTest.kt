package org.example.project.viewmodel

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LoginViewModelTest {

    @Test
    fun `inicio de sesión exitoso`() {
        val viewModel = LoginViewModel()
        viewModel.login("test@test.com", "password")
        assertTrue(viewModel.state.loggedIn)
        assertNull(viewModel.state.error)
    }

    @Test
    fun `inicio de sesión con usuario inválido`() {
        val viewModel = LoginViewModel()
        viewModel.login("test", "password")
        assertFalse(viewModel.state.loggedIn)
        assertEquals("El usuario no es valido", viewModel.state.error)
    }

    @Test
    fun `inicio de sesión con contraseña inválida`() {
        val viewModel = LoginViewModel()
        viewModel.login("test@test.com", "1234")
        assertFalse(viewModel.state.loggedIn)
        assertEquals("La contraseña no es valida", viewModel.state.error)
    }
}