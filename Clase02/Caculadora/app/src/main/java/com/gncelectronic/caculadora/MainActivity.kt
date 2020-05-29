package com.gncelectronic.caculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * funcion suma
     */
    fun sum(view : View){
        val value1 = txtNumero1.text.toString().toDouble()
        val value2 = txtNumero2.text.toString().toDouble()
        txtViewResultado.text = "Resultado: ${value1 + value2}"
    }

    /**
     * Funcion resta
     */
    fun sub(view : View){
        val value1 = txtNumero1.text.toString().toDouble()
        val value2 = txtNumero2.text.toString().toDouble()
        txtViewResultado.text = "Resultado: ${value1 - value2}"
    }

    /**
     * Funcion multiplicacion
     */
    fun mult(view: View){
        val value1 = txtNumero1.text.toString().toDouble()
        val value2 = txtNumero2.text.toString().toDouble()
        txtViewResultado.text = "Resultado: ${value1 * value2}"
    }

    /**
     * Funcion division
     */
    fun div(view: View){
        val value1 = txtNumero1.text.toString().toDouble()
        val value2 = txtNumero2.text.toString().toDouble()
        txtViewResultado.text = "Resultado: ${value1 / value2}"
    }

}
