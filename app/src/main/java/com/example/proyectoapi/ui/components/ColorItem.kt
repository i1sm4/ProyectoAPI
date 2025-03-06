package com.example.proyectoapi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proyectoapi.model.ColorResponse

@Composable
fun ColorItem(color: ColorResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color(android.graphics.Color.parseColor(color.hex.value)))
                .padding(16.dp)
        ) {
            AsyncImage(
                model = color.image.bare,
                contentDescription = color.name.value,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = color.name.value, color = Color.White)
        }
    }
}
