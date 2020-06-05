package com.gncelectronic.conversorlivedata.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val USD_TO_PESOS: Float = 63.5F
    private val resultado : MutableLiveData<Float> = MutableLiveData()
    private var dolarText = ""

    fun convertirMonto(valor : String){
        this.dolarText = valor
        resultado.value =valor.toFloat()*USD_TO_PESOS

    }

    fun obtenerConversion():MutableLiveData<Float>{
        return resultado
    }
}
