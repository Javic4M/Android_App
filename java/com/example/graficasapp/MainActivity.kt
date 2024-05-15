package com.example.graficasapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.graficasapp.analizadores.LexicoKoltlin
import com.example.graficasapp.analizadores.SintacticoKoltlin
import com.example.graficasapp.graficas.ConstruccionHTML
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.StringReader


open class MainActivity : AppCompatActivity() {

    private lateinit var botonAnalizar: Button
    private lateinit var botonAgregar: Button
    private lateinit var botonExportar: Button
    private lateinit var botonBuscar: Button
    private lateinit var botonCrear: Button
    private lateinit var panelTexto: EditText
    private lateinit var nombreArchivo: String
    private var codigoAnalizado: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        abrirArchivo()
    }

    private fun iniciarComponentes() {
        botonAnalizar = findViewById(R.id.botonAnalizar)
        botonAgregar = findViewById(R.id.botonAgregar)
        botonExportar = findViewById(R.id.botonExportar)
        botonBuscar = findViewById(R.id.botonBuscar)
        botonCrear = findViewById(R.id.botonCrear)
        panelTexto = findViewById(R.id.panelTexto)
        nombreArchivo = ""
        agregarListener()
    }

    private fun agregarListener() {
        panelTexto.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                codigoAnalizado = false
                guardarArchivo()
            }
        })
        botonAnalizar.setOnClickListener {
            val codigo = panelTexto.text.toString()

            if (codigo.isNotEmpty()) {
                colorearPanel()
                compilar(codigo)
                guardarArchivo()
            } else {
                Toast.makeText(this, "Debe Ingresar un Codigo para Analizar", Toast.LENGTH_SHORT).show()
            }
        }
        botonAgregar.setOnClickListener {
            val intentar = Intent(this, AgregarActivity::class.java)
            intentar.putExtra("nombre", nombreArchivo)
            startActivity(intentar)
        }
        botonExportar.setOnClickListener {

            if (codigoAnalizado) {
                val control = ConstruccionHTML(panelTexto.getText().toString())
                val paginaHTML: String = control.analizarTokens()
                val nombre: String = control.obtenerNombre()

                try {
                    val archivo = OutputStreamWriter(openFileOutput(nombre, MODE_PRIVATE))
                    archivo.write(paginaHTML)
                    archivo.flush()
                    archivo.close()
                    Toast.makeText(this, "Exportando Documento", Toast.LENGTH_SHORT).show()
                } catch (e: IOException) {
                    Log.i("Todo Correcto", "Error")
                }

            } else {
                Toast.makeText(this, "Debe Analizar el Codigo Antes", Toast.LENGTH_SHORT).show()
            }
        }
        botonBuscar.setOnClickListener {
            guardarArchivo()
            val intentar = Intent(this, MainActivity3::class.java)
            startActivity(intentar)
        }
        botonCrear.setOnClickListener {
            guardarArchivo()
            val intentar = Intent(this, MainActivity2::class.java)
            startActivity(intentar)
        }
    }

    private fun compilar(codigo: String) {
        val lexico = LexicoKoltlin(StringReader(codigo))
        val parser = SintacticoKoltlin(lexico)

        try {
            parser.parse()
            codigoAnalizado = true
            Toast.makeText(this, "Codigo Correcto, listo para Exportar", Toast.LENGTH_SHORT).show()
        } catch (_: Exception) {
            val sym = parser.symbol

            if (sym != null) {
                when (sym.sym) {
                    0 -> Toast.makeText(this, "Error Sintáctico en la linea ${sym.left}, columna ${sym.right}: Se esperaba el Resto de la Intruccion", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this, "Error Sintáctico en la linea ${sym.left}, columna ${sym.right}: ${parser.contenido}", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Error){
            Toast.makeText(this, "Error Léxico: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun abrirArchivo() {
        val dato = intent.getStringExtra("dato")

        if (dato != null) {
            nombreArchivo = dato

            try {
                val archivo = InputStreamReader(openFileInput("${dato}.gh"))
                val buffer = BufferedReader(archivo)
                var linea = buffer.readLine()
                var contenido = ""

                while (linea != null) {
                    contenido = contenido + linea + "\n"
                    linea = buffer.readLine()

                }
                panelTexto.setText(contenido)
                buffer.close()
                archivo.close()
                Toast.makeText(this, "Abriendo Archivo", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                Toast.makeText(this, "El Archivo no Existe", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun guardarArchivo() {
        if (nombreArchivo.isNotEmpty()) {
            try {
                val archivo = OutputStreamWriter(openFileOutput("${nombreArchivo}.gh", MODE_PRIVATE))
                archivo.write(panelTexto.text.toString())
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {
                Toast.makeText(this, "No se puedo Crear", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun colorearPanel() {

        if (panelTexto.text.isNotEmpty()) {
            val palabrasClave = mapOf(
                "==" to Color.BLUE,
                "!=" to Color.BLUE,
                ">" to Color.BLUE,
                "<" to Color.BLUE,
                "<=" to Color.BLUE,
                ">=" to Color.BLUE,
                "if" to Color.YELLOW,
                "else" to Color.YELLOW,
                "do" to Color.YELLOW,
                "while" to Color.YELLOW,
                "for" to Color.YELLOW,
                "\"title\"" to Color.rgb(255, 165, 0),
                "\"description\"" to Color.rgb(255, 165, 0),
                "\"keywords\"" to Color.rgb(255, 165, 0),
                "\"header\"" to Color.rgb(255, 165, 0),
                "\"footer\"" to Color.rgb(255, 165, 0),
                "\"backgroundColor\"" to Color.rgb(255, 165, 0),
                "\"fontFamily\"" to Color.rgb(255, 165, 0),
                "\"fontSize\"" to Color.rgb(255, 165, 0),
                "\"data\"" to Color.rgb(255, 165, 0),
                "\"chart\"" to Color.rgb(255, 165, 0),
                "\"xAxisLabel\"" to Color.rgb(255, 165, 0),
                "\"yAxisLabel\"" to Color.rgb(255, 165, 0),
                "\"name\"" to Color.rgb(255, 165, 0),
                "\"points\"" to Color.rgb(255, 165, 0),
                "\"label\"" to Color.rgb(255, 165, 0),
                "\"color\"" to Color.rgb(255, 165, 0),
                "\"x\"" to Color.rgb(255, 165, 0),
                "\"y\"" to Color.rgb(255, 165, 0),
                "{" to Color.MAGENTA,
                "}" to Color.MAGENTA,
                "[" to Color.MAGENTA,
                "]" to Color.MAGENTA,
                "default" to Color.BLUE
            )

            val spannableString = SpannableString(panelTexto.text)
            palabrasClave.keys.forEach { palabra ->
                var startIndex = panelTexto.text.indexOf(palabra)
                while (startIndex != -1) {
                    val endIndex = startIndex + palabra.length
                    spannableString.setSpan(
                        ForegroundColorSpan(palabrasClave[palabra]!!),
                        startIndex,
                        endIndex,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    startIndex = panelTexto.text.indexOf(palabra, endIndex)
                }
            }

            val numeroRegex = "\\b\\d+\\b".toRegex() // Expresión regular para encontrar números enteros
            numeroRegex.findAll(panelTexto.text).forEach { matchResult ->
                val startIndex = matchResult.range.first
                val endIndex = matchResult.range.last + 1 // +1 porque endIndex es exclusivo
                spannableString.setSpan(
                    ForegroundColorSpan(Color.GREEN), // Puedes cambiar el color según tu preferencia
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            panelTexto.setText(spannableString)
        }
    }
    
}