package com.example.graficos_artesanos.services

import android.content.ContentValues.TAG
import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket


class ClientManager {
    private val socket: Socket = IO.socket("http://192.168.157.38:3000/")

    companion object {
        val clientManager: ClientManager = ClientManager();
    }

    init {
        socket.on(Socket.EVENT_CONNECT) {
            Log.d(
                TAG, "Connected to server"
            )
        }

        socket.on("number message") { args ->
            val message = args[0] as Double
            Log.d(
                TAG, "Received message: $message"
            )
        }

        socket.on(Socket.EVENT_DISCONNECT) {
            Log.d(
                TAG, "Disconnected to server"
            )
        }
    }

    fun connect() {
        try {
            Log.d(
                TAG, "Holaaaaa"
            )
            socket.connect()
        } catch (exception: Exception) {
            Log.d(
                TAG, "Fallo al conectar"
            )
        }
    }

    fun disconnect() {
        socket.disconnect()
    }

}