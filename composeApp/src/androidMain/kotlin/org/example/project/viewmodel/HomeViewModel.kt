package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.repository.productos

class HomeViewModel: ViewModel() {

    var state by mutableStateOf(productos)
        private set


}