package com.example.graficos_artesanos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import com.example.graficos_artesanos.services.ClientManager
import com.example.graficos_artesanos.ui.screens.HomeScreen
import com.example.graficos_artesanos.ui.widgets.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Incializamos el  viewModel para poder usarlo en todo el programa
        val viewModel: ViewModel by viewModels()

        // Inicializamos nuestro servicio y le pasamos por parametro el viewmodel
        val clientManager = ClientManager.createInstance(viewModel)

        enableEdgeToEdge()
        setContent {
            // Scaffold para darle el padding principal a la pantalla
            Scaffold { paddingValues ->
                HomeScreen(paddingValues, viewModel)
            }
        }
    }
}