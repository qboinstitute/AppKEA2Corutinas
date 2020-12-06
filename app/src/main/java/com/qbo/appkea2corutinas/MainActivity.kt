package com.qbo.appkea2corutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.Main) {
            val resultado = withContext(Dispatchers.IO){
                ProveedorDeDatos.TareaPesada()
            }


            mostrarMensaje(if (resultado) "Terminó la carga" else "Error")
        }

        btncambiarnombre.setOnClickListener {
            tvmensaje.setText("Cambiamos el título")

        }

    }

    private fun mostrarMensaje(mensaje: String){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }


}