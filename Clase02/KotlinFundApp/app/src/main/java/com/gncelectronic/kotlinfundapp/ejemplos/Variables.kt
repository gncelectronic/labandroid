package com.gncelectronic.kotlinfundapp.ejemplos

import android.util.Log

/**
 * https://kotlinlang.org/docs/reference/basic-types.html
 * En kotlin todo es un bojeto
 *No hay tipos basicos no existe void. Si algo no existe estamos devolviendo un  unit Object.
 *Las variables pueden ser mutable (var) o inmutables (val) usaremos siempre que sea posible variables inmutables.
 * Los tipos de datos son definidos despues del nombre de la variable, con dos puntos y espacio.
 */
class Variables {
    private var variable0 = 1
    private var variable1= 1.toByte()
    private var variable2= -344

    //Long
    private var varLong1 = 122222222222222223
    private var varLong2 = 122L

    //Float
    private var varFloat1 =23.5.toFloat()
    private var varFloat2 =23.5f
    //Double
    private var varDouble1 = 23.5

    //Char
    private var varChar1='A'

    //String
    private var varString1="A"

    private var varBoolean1=true

   fun workInteger(){
       Log.i("INTEGER", "------INTEGER-------")
       //Declaracion
       var myInteger : Int
       //Inicializacion
       myInteger =10

       Log.i("INTEGER","Es variable0 un integer?"+ (variable0 is Int))
       Log.i("INTEGER","Es variable1 un byte?"+ (variable1 is Byte))

       Log.i("INTEGER", "variable2 $variable2 le cambiamos el valor almacenado por")
       variable2=Int.MAX_VALUE
       Log.i("INTEGER", "variable2 $variable2 ")
   }

    fun workLong(){
        Log.i("LONG", "La variable varLong1 tiene un Long: "+ (varLong1 is Long))
        Log.i("LONG", "La variable varLong2 tiene un Long: "+ (varLong2 is Long))
    }

    fun workFloat(){
        Log.i("FLOAT","La variable varFloat1 tiene un valor float: "+ (varFloat1 is Float))
        Log.i("FLOAT","La variable varFloat2 tiene un valor float: "+ (varFloat2 is Float))
    }

    fun workDouble(){
        Log.i("DOUBLE","La variable varDouble1 tiene un valor double: "+ (varDouble1 is Double))
    }

    /**
     * Trabajar con char
     */
    fun workChar(){
        Log.i("CHAR","La variable varChar1 tiene un valor char: " +(varChar1 is Char))
    }

    /**
     * Trabajar con String
     */
    fun workString(){
        Log.i("CASE_STRING","la variable varString1 tiene un string: "+ (varString1 is String))
        //String en varias lineas

        /**
         * Estilo Java
         */
        var varString2 ="Hola mundo \n saludos."

        /**
         * Estilo Kotlin
         */
        var varString3 = """Hola mundo
                Saludos
        """.trimMargin()

        Log.i("CASE_STRING", "Estilo Java: $varString2")
        Log.i("CASE_STRING", "Estilo Kotlin: $varString2")


        /**
         *  String Templates KotlinNullPointerException
         */

        var nota = 41
        var maxNota =100
        varString3 ="Mi nota fue $nota/$maxNota"
        Log.i("CASE_STRING",varString3)
        varString3 = "multiplico la nota ${nota *1.5}"

        Log.i("CASE_STRING",varString3)

    }

    fun workBoolean(){
        Log.i("BOOLEAN", "La variable varBoolean1 tiene un booleano: " +(varBoolean1 is Boolean))
    }

    fun workArrays(){
        var varArray = arrayOf(1,3,4,5)
        Log.i("ARRAYS", "varArray es una arreglo: " + (varArray is Array))

        /**
         * Caso de arreglos con nulos
         *
         */

       var  varArray1 = arrayOfNulls<Int>(3)
        varArray1 = arrayOf(1,4,3,5)
        varArray1[0]?.toFloat() //Safe call llamada segura en caso de ser null deveulve null
        varArray1[0]?.toFloat()?:"Error" //Operador Elvis -- En caso de ser nulo devuelve Error
        varArray1[0]!!.toFloat() //Si el valor es nulo va a lanzar un null pointer exception Cuidado al usar este operador.


    }


}