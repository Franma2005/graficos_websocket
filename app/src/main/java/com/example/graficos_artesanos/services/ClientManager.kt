package com.example.graficos_artesanos.services


import android.content.ContentValues.TAG
import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import com.example.graficos_artesanos.ui.widgets.ViewModel

class ClientManager(private val viewModel: ViewModel) {
    // Atención Profesor: Para las pruebas en la aplicación es necesario cambiar la IP por la de tu ordenador
    private val socket: Socket = IO.socket("http://192.168.1.205:3000/")

    // Patron Singleton
    companion object {
        private var instance: ClientManager? = null

        fun createInstance(viewModel: ViewModel): ClientManager {
            if (instance == null)
                instance = ClientManager(viewModel)
            return instance!!
        }

        fun getInstance(): ClientManager {
            return instance!!
        }
    }

    // El init se ejecuta justo después del constructor principal. Establecemos los eventos del
    // socket
    init {
        // Si se conecta lanza un log
        socket.on(Socket.EVENT_CONNECT) {
            Log.d(TAG, "Connected to server")
        }

        // Este evento se usa para enviar números aleatorios
        socket.on("number message") { args ->
            val message = args[0] as Double
            val intValue = message.toInt()
            Log.d(TAG, "Received message: $message")

            // Añadir el nuevo valor al ViewModel
            viewModel.addValue(intValue)
        }

        // Log de desconexion
        socket.on(Socket.EVENT_DISCONNECT) {
            Log.d(TAG, "Disconnected from server")
        }
    }

    // Esta función hace que nuestro programa cliente (Este) se conecte al servidor
    fun connect() {
        try {
            Log.d(TAG, "Conectando al servidor de sockets...")
            socket.connect()
        } catch (exception: Exception) {
            Log.d(TAG, "Fallo al conectar: ${exception.message}")
        }
    }

    // Esta función desconecta nuestro programa cliente
    fun disconnect() {
        socket.disconnect()
    }
}