package com.example.graficasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var botonBuscar: Button
    private lateinit var panelTexto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        botonBuscar = findViewById(R.id.botonBuscarArchivo)
        panelTexto = findViewById(R.id.panelTexto)
        agregarListener()
    }

    private fun agregarListener() {
        botonBuscar.setOnClickListener {
            val intentar = Intent(this, MainActivity::class.java)
            intentar.putExtra("dato",panelTexto.getText().toString())
            startActivity(intentar)
        }
    }
}