package com.example.proyectoapi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectoapi.ui.components.ColorItem
import com.example.proyectoapi.ui.viewmodel.ColorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorListScreen(viewModel: ColorViewModel = viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchColors()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Colores", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Button(
                onClick = { viewModel.fetchColors() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Recargar Colores")
            }

            if (viewModel.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                LazyColumn {
                    items(viewModel.colors) { color ->
                        ColorItem(color)
                    }
                }
            }
        }
    }
}
