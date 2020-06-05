package com.gncelectronic.conversorviewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
   private val USD_TO_PESOS : Float = 68.66F
   private var resultado : Float = 0.0F

   private var dolarText=""

    fun convertirMonto(valor: String){
        this.dolarText = valor
        resultado = valor.toFloat()* USD_TO_PESOS

    }

    fun obtenerConversion():Float{
        return resultado
    }

}
