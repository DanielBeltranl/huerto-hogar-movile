package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.model.Producto
import org.example.project.repository.ProductoRepository

sealed class UiState {
    object Loading : UiState()
    data class Success(val productos: List<Producto>?) : UiState()
    data class Error (val message : String ): UiState()
}

class HomeViewModel(private val repository: ProductoRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        loadProductos()
    }

    fun loadProductos(){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = repository.getListaProductos()
            result.fold(
                onSuccess = { productos ->
                    _uiState.value = UiState.Success(productos)
                },
                onFailure = { exception ->
                    _uiState.value = UiState.Error(exception.message?: "error al cargar los productos")
                }
            )
        }
    }

    fun refresh() {
        loadProductos()
    }
}