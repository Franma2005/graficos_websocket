package com.example.graficos_artesanos.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.graficos_artesanos.entities.BarchartInput

@Composable
fun BarChart(
    inputList: List<BarchartInput>,
    modifier: Modifier = Modifier
) {
    // Calcular la suma una sola vez y convertirla a float inmediatamente
    val listSum = remember(inputList) {
        inputList.sumOf { it.value }.toFloat()
    }

    Row(
        verticalAlignment = Alignment.Bottom, // Cambiar a Bottom para que las barras se alineen en la parte inferior
        horizontalArrangement = Arrangement.SpaceEvenly, // Usar SpaceEvenly para distribuir mejor
        modifier = modifier
    ) {
        inputList.forEach { input ->
            val percentage = input.value / listSum
            Bar(
                modifier = Modifier
                    .height(200.dp * percentage) // Altura proporcional al porcentaje
                    .width(40.dp), // Añadir un ancho fijo para cada barra
                color = input.color,
                percentage = percentage
            )
        }
    }
}