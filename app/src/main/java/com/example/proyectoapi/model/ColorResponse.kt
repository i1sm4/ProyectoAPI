package com.example.proyectoapi.model

data class ColorResponse(
    val name: ColorName,
    val hex: ColorHex,
    val image: ColorImage
)

data class ColorName(val value: String)
data class ColorHex(val value: String)
data class ColorImage(val bare: String)
