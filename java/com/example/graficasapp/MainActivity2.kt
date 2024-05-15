package com.example.graficasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.OutputStreamWriter

open class MainActivity2 : AppCompatActivity() {

    private lateinit var nombreArchivo: EditText
    private lateinit var botonCrear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        nombreArchivo = findViewById(R.id.nombreArchivoNuevo)
        botonCrear = findViewById(R.id.botonCrearNuevo)
        agregarListener()
    }

    private fun agregarListener() {
        botonCrear.setOnClickListener {
            guardarArchivo()
            val intentar = Intent(this, MainActivity::class.java)
            startActivity(intentar)
        }
    }

    private fun guardarArchivo() {
        try {
            val archivo = OutputStreamWriter(openFileOutput("${nombreArchivo.text}.gh", MODE_PRIVATE))
            archivo.close()
            Toast.makeText(this, "Se Creo el Archivo", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "No se puedo Crear el Archivo", Toast.LENGTH_SHORT).show()
        }
    }
}