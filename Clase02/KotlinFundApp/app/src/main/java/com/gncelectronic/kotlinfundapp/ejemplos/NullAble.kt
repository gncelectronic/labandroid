package com.gncelectronic.kotlinfundapp.ejemplos

import android.util.Log
import java.lang.NullPointerException

/**
 * Operadores relacionados con la nulabilidad:
 *  only-safe (?)
 *  non-null asserted (!!)
 *  Sistema de tipado de Kotlin está  pensado para eliminar  de nuestro código el NullPointerException NPE.
 *  Los 4 únicos posibles casos de NPE son:
 *  1) Una llamada explicita al error NullPointerException()
 *  2) Uso del operador !!
 *  3) Código externo Java
 *  4) Alguna inconsistencia de datos en relación a la incialización
 */
class NullAble {
    private lateinit var variable1: String //Es inicializada luego
    private var variable2: String? = null

    /**
     * Caso 1 llamada explicita
     */
    fun workNPE(): java.lang.NullPointerException {
        return NullPointerException()
    }

    /**
     * Caso 2 uso de !!
     */
    fun workOnlySafe(var1: String?) {
        Log.e("CASE-NULL", var1.toString())  //devuelve nulo en caso que var1 sea null
        Log.e("CASE-NULL", var1!!.toString())  //lanza un NPE si var1 es nulo
    }

    /**
     *  Caso 3 llamando a una clase java
     *
     */
    fun workcallJavaClass() {
        ClaseJava.getNPE()
    }


    fun workWrongIni() {
       // variable1.length //devuelve NPE porque no ha sido inicializada
        Log.e("CASE-NULL", "${variable2?.length}")
        variable2!!.length
    }


}