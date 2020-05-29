package com.gncelectronic.kotlinfundapp.ejemplos

import android.util.Log

/**
 * https://kotlinlang.org/docs/reference/control-flow.html
 */
class ControlFlujo {

    fun workIfExpression(){
        var num1 = 120
        var num2 = 20
        if(num1 >num2){
            if (num1 > num2) {
                Log.i("CASE-IF", "NUM1 es mayor que NUM2")
            } else

           {
                Log.i("CASE-IF", "NUM2 es mayor que NUM1")
            }
        }


        //Como expresion

        if(num1 >num2) Log.i("CASE-IF","num1 es mayor que num2") else
            Log.i("CASE-IF", "num2 es mayor que num1")

    }


    fun workWhen(){
        //When es similar a swich de Java
        val x=1
        when(x){
            1 -> Log.i("CASE-WHEN", "x==1")
            2 ->Log.i("CASE-WHEN", "x==2")
            else -> Log.i("CASE-WHEN","x es otro numero") //el case default no es obligatorio
        }


    when(x){
        0,1 -> Log.i("CASE-WHEN","x==0 o x==1")
    }

        /**
         * Sin argumentos
         */
        when{
            (x % 2 == 0) -> Log.i("CASE-WHEN","Numero par")
            (x% 2 ==1) -> Log.i("CASE-WHEN","Numero impar")
        }

        /**
         * Sin argumento y devolviendo un valor
         */
        val esPar = when {
            (x% 2 == 0 ) -> true
            else -> false
        }



    }


    fun workFor(){
        val numeros = arrayOf(1,2,3,4,5)
        for(numero in numeros) Log.i("CASE-FOR", numero.toString())
        /**
         * Especificando el tipo
         */
        for(numero : Int in numeros) Log.i("CASE-FOR", numero.toString())
        /**
         * Con indices
         */
        for((indice, numero) in numeros.withIndex())  Log.i("CASE-FOR", "$indice $numero")

    }

    fun worWhileDoWhile(){
        var x = 10
        while(x > 0){
            Log.w("CASE-WHILE", x--.toString())
        }

       do{
           Log.i("CASE-WHILE", "Primera y unica iteracion")
       }while(x>0)
    }

}