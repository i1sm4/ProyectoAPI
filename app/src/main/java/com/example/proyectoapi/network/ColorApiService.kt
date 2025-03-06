package com.example.proyectoapi.network

import com.example.proyectoapi.model.ColorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorApiService {
    @GET("id")
    suspend fun getColorInfo(
        @Query("hex") hex: String
    ): ColorResponse
}
