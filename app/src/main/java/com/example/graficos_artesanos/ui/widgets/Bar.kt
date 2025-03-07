package com.example.graficos_artesanos.ui.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun Bar(
    modifier: Modifier = Modifier,
    color: Color,
    percentage: Float
) {
    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .background(Color.Transparent), // Añadir un fondo transparente para depuración
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val width = size.width
            val height = size.height

            // Usar toda la anchura disponible
            val barWidth = width
            // Usar toda la altura disponible (ya ajustada por el porcentaje en el modificador)
            val barHeight = height

            val path = Path().apply {
                moveTo(0f, height)
                lineTo(barWidth, height)
                lineTo(barWidth, 0f) // Usar toda la altura
                lineTo(0f, 0f)
                close()
            }

            drawPath(
                path,
                brush = Brush.verticalGradient(
                    colors = listOf(color, color.copy(alpha = 0.7f))
                )
            )
        }
    }
}