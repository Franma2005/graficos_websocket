package com.example.graficos_artesanos.ui.widgets

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.graficos_artesanos.entities.BarchartInput
import com.example.graficos_artesanos.ui.theme.brightBlue
import com.example.graficos_artesanos.ui.theme.orange
import com.example.graficos_artesanos.ui.theme.green
import com.example.graficos_artesanos.ui.theme.purple
import com.example.graficos_artesanos.ui.theme.blueGray
import com.example.graficos_artesanos.ui.theme.redOrange
import com.example.graficos_artesanos.ui.theme.darkGray

class ViewModel : ViewModel() {
    // Lista de colores para las barras
    private val colors = listOf(
        orange, brightBlue, green, purple, blueGray, redOrange, darkGray
    )

    // Estado para los valores de las barras - empezamos con una lista vacía
    var barValues by mutableStateOf(listOf<Int>())
        private set

    // Lista de BarchartInput para el gráfico
    var barInputs by mutableStateOf(emptyList<BarchartInput>())
        private set

    // Añade un nuevo valor como una nueva barra
    fun addValue(value: Int) {
        // Determinar el próximo color a usar
        val nextColorIndex = barValues.size % colors.size

        // Añadir el nuevo valor a la lista
        barValues = barValues + value

        // Actualizar las entradas del gráfico
        barInputs = barInputs + BarchartInput(value, colors[nextColorIndex])
    }

    // Metodo para resetear los valores si es necesario
    fun resetValues() {
        barValues = emptyList()
        barInputs = emptyList()
    }
}