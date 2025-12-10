package org.example.project.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.model.CastMember
import org.example.project.repository.RetrofitInstance

class ProfileViewModel : ViewModel() {
    var castMember by mutableStateOf<CastMember?>(null)
        private set

    init {
        getRandomCastMember()
    }

    private fun getRandomCastMember() {
        viewModelScope.launch {
            try {
                val cast = RetrofitInstance.tvMazeApi.getShowCast(118)
                if (cast.isNotEmpty()) {
                    castMember = cast.random()
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
