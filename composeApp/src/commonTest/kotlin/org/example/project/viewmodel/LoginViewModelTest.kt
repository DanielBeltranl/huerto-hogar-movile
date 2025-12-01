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
        viewModel.login("test@test.com", "passwordvalido")
        assertTrue(viewModel.state.loggedIn, "El inicio de sesión debería ser exitoso")
        assertNull(viewModel.state.error, "No debería haber ningún error")
    }

    @Test
    fun `falla el inicio de sesión por correo inválido`() {
        val viewModel = LoginViewModel()
        viewModel.login("usuario-invalido", "passwordvalido")
        assertFalse(viewModel.state.loggedIn, "El inicio de sesión no debería ocurrir")
        assertEquals("El usuario no es valido", viewModel.state.error, "El mensaje de error no es el esperado")
    }

    @Test
    fun `falla el inicio de sesión por contraseña corta`() {
        val viewModel = LoginViewModel()
        viewModel.login("test@test.com", "corta")
        assertFalse(viewModel.state.loggedIn, "El inicio de sesión no debería ocurrir")
        assertEquals("La contraseña no es valida", viewModel.state.error, "El mensaje de error no es el esperado")
    }
}