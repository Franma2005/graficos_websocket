package com.example.graficos_artesanos.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.graficos_artesanos.entities.BarchartInput

@Composable
fun BarChart(
    inputList: List<BarchartInput>,
    modifier: Modifier = Modifier
) {
    // Calcular el valor máximo para la escala (para que las barras se escalen en relación al mayor valor)
    val maxValue = remember(inputList) {
        val max = inputList.maxOfOrNull { it.value } ?: 0
        max.coerceAtLeast(1) // Evitar división por cero
    }

    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        inputList.forEach { input ->
            // Calcular altura relativa al máximo
            val heightPercentage = input.value.toFloat() / maxValue

            Bar(
                modifier = Modifier
                    .height((200.dp * heightPercentage).coerceAtLeast(1.dp)) // Al menos 1dp para ser visible
                    .width(40.dp),
                color = input.color,
                percentage = heightPercentage
            )
        }
    }
}