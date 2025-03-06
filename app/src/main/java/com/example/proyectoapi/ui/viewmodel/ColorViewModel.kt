package com.example.proyectoapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.proyectoapi.model.ColorResponse
import com.example.proyectoapi.repository.ColorRepository

class ColorViewModel : ViewModel() {
    private val repository = ColorRepository()

    var colors by mutableStateOf<List<ColorResponse>>(emptyList())
        private set
    var isLoading by mutableStateOf(false)
        private set

    private val hexList = listOf(
        "0047AB", "FF5733", "4CAF50", "FFC107", "9C27B0",
        "E91E63", "3F51B5", "00BCD4", "8BC34A", "FFEB3B",
        "795548", "607D8B", "F44336", "9E9E9E", "673AB7"
    )
    fun fetchColors() {
        viewModelScope.launch {
            isLoading = true
            colors = repository.fetchColors(hexList)
            isLoading = false
        }
    }
}
