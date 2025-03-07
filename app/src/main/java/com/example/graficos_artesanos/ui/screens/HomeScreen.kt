package com.example.graficos_artesanos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.graficos_artesanos.entities.BarchartInput
import com.example.graficos_artesanos.services.ClientManager.Companion.clientManager
import com.example.graficos_artesanos.ui.theme.blueGray
import com.example.graficos_artesanos.ui.theme.brightBlue
import com.example.graficos_artesanos.ui.theme.darkGray
import com.example.graficos_artesanos.ui.theme.green
import com.example.graficos_artesanos.ui.theme.orange
import com.example.graficos_artesanos.ui.theme.purple
import com.example.graficos_artesanos.ui.theme.redOrange
import com.example.graficos_artesanos.ui.widgets.BarChart

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    clientManager.connect()

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
            Text(text = "Gráfico de Barras")

            // Añadir altura fija para el contenedor del gráfico
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = 16.dp)
            ) {
                BarChart(
                    listOf(
                        BarchartInput(28, orange),
                        BarchartInput(15, brightBlue),
                        BarchartInput(11, green),
                        BarchartInput(7, purple),
                        BarchartInput(14, blueGray),
                        BarchartInput(9, redOrange),
                        BarchartInput(21, darkGray)
                    ),
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}