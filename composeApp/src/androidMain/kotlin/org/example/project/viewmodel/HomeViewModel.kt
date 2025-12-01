package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.repository.ProductRepository

class HomeViewModel(private val repository: ProductRepository) : ViewModel() {

    var state by mutableStateOf(repository.obtenerProductos())
        private set

}