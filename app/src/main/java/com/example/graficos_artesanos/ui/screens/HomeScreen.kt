package com.example.graficos_artesanos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.graficos_artesanos.services.ClientManager
import com.example.graficos_artesanos.ui.widgets.BarChart
import com.example.graficos_artesanos.ui.widgets.ViewModel

@Composable
fun HomeScreen(paddingValues: PaddingValues, viewModel: ViewModel) {
    // Conectar al socket cuando se muestra la pantalla
    DisposableEffect(Unit) {
        val clientManager = ClientManager.getInstance()
        clientManager.connect()

        // Desconectar cuando se destruye el composable
        onDispose {
            clientManager.disconnect()
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Contenedor con altura fija para el gráfico
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = 16.dp)
            ) {
                // Usar los valores dinámicos del ViewModel
                BarChart(
                    inputList = viewModel.barInputs,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}