package com.example.graficasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.graficasapp.graficas.GraficaCodigo
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class AgregarActivity : AppCompatActivity() {

    private lateinit var botonBarra: Button
    private lateinit var botonPastel: Button
    private lateinit var botonPuntos: Button
    private lateinit var botonLineas: Button
    private lateinit var botonSimple: Button
    private lateinit var botonCompleto: Button
    private lateinit var botonAgregar: Button
    private lateinit var nombreDelArchivo: String
    private var numeroDeGrafica: Int = 0
    private var tipoDeEstilo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)
        iniciarComponentes()
        obtenerNombre()
    }

    private fun iniciarComponentes() {
        botonBarra = findViewById(R.id.botonBarra)
        botonPastel = findViewById(R.id.botonPastel)
        botonPuntos = findViewById(R.id.botonPuntos)
        botonLineas = findViewById(R.id.botonLineas)
        botonSimple = findViewById(R.id.botonSimple)
        botonCompleto = findViewById(R.id.botonCompleto)
        botonAgregar = findViewById(R.id.botonAgregar)
        agregarListener()
    }

    private fun agregarListener() {
        botonBarra.setOnClickListener {
            bloquearBotonesGrafica()
            botonBarra.isEnabled = true
            numeroDeGrafica = 1
        }
        botonPastel.setOnClickListener {
            bloquearBotonesGrafica()
            botonPastel.isEnabled = true
            numeroDeGrafica = 2
        }
        botonPuntos.setOnClickListener {
            bloquearBotonesGrafica()
            botonPuntos.isEnabled = true
            numeroDeGrafica = 3
        }
        botonLineas.setOnClickListener {
            bloquearBotonesGrafica()
            botonLineas.isEnabled = true
            numeroDeGrafica = 4
        }
        botonSimple.setOnClickListener {
            bloquearBotonesEstilo()
            botonSimple.isEnabled = true
            tipoDeEstilo = 1
        }
        botonCompleto.setOnClickListener {
            bloquearBotonesEstilo()
            botonCompleto.isEnabled = true
            tipoDeEstilo = 2
        }
        botonAgregar.setOnClickListener {
            if (!botonBarra.isEnabled || !botonPastel.isEnabled || !botonPuntos.isEnabled || !botonLineas.isEnabled) {
                if (!botonSimple.isEnabled || !botonCompleto.isEnabled) {
                    modificarArchivo()
                    val intentar = Intent(this, MainActivity::class.java)
                    intentar.putExtra("dato", nombreDelArchivo)
                    startActivity(intentar)
                } else {
                    Toast.makeText(this, "Debe Seleccionar un Estilo de Pantilla", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Debe Seleccionar un Tipo de Grafica", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun modificarArchivo() {
        try {
            val archivo = InputStreamReader(openFileInput("${nombreDelArchivo}.gh"))
            val buffer = BufferedReader(archivo)

            var linea = buffer.readLine()
            val contenido: ArrayList<String> = ArrayList()

            while (linea != null) {
                contenido.add(linea + "\n")
                linea = buffer.readLine()
            }
            buffer.close()
            archivo.close()
            guardarCambios(contenido)
        } catch (e: IOException) {
            Toast.makeText(this, "El Archivo no Existe", Toast.LENGTH_SHORT).show()
        }
    }

    private fun guardarCambios(contenido: ArrayList<String>) {
        val graficaCodigo = GraficaCodigo(numeroDeGrafica, tipoDeEstilo)
        val codigoAIngresar = graficaCodigo.obtenerCodigo()

        if (contenido.isEmpty()) {
            contenido.add(codigoAIngresar + "\n")
        } else {
            contenido.add(contenido.size - 1, codigoAIngresar + "\n")
        }

        try {
            val archivo = OutputStreamWriter(openFileOutput("${nombreDelArchivo}.gh", MODE_PRIVATE))

            for (elemento in contenido) {
                archivo.write(elemento)
            }
            archivo.flush()
            archivo.close()
        } catch (e: IOException) {
            Toast.makeText(this, "No se puedo Modificar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun obtenerNombre() {
        nombreDelArchivo = intent.getStringExtra("nombre").toString()
    }

    private fun bloquearBotonesGrafica() {
        botonBarra.isEnabled = false
        botonPastel.isEnabled = false
        botonPuntos.isEnabled = false
        botonLineas.isEnabled = false
    }

    private fun bloquearBotonesEstilo() {
        botonSimple.isEnabled = false
        botonCompleto.isEnabled = false
    }
}