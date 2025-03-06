package com.example.proyectoapi.repository

import com.example.proyectoapi.model.ColorResponse
import com.example.proyectoapi.network.RetrofitClient

class ColorRepository {
    private val api = RetrofitClient.api

    suspend fun fetchColors(hexList: List<String>): List<ColorResponse> {
        return hexList.mapNotNull { hex ->
            try {
                api.getColorInfo(hex)
            } catch (e: Exception) {
                null // Manejo de errores, evitar que la app crashee
            }
        }
    }
}
