package com.gncelectronic.kotlinfundapp.ejemplos

import android.util.Log

class Operadores {
    fun workEquals(){
        var a= Figura("Cuadrado")
        var b= Figura("Cuadrado")

        a=b

        Log.i("CASE-OPER","Igualdad referencial. ¿Es a igual a b?  ${a===b}" )//
        Log.i("CASE-OPER","Igualdad estructural. ¿Es a igual a b? ${a==b}") //comparamos contenido es
        // false porque no sobrescribimos   el metodo equals()


    }

    /**
     * En el caso de dataclass se compara los objetos por su contenido para el equals estructural
     */
    fun workEqualsDataClass(){
        var c= FiguraV2("Cuadrado")
        var d= FiguraV2("Cuadrado")
        var e= FiguraV2("Circulo")



        Log.i("CASE-OPER","Igualdad referencial. ¿Es c igual a d?  ${c===d}" )//false
        Log.i("CASE-OPER","Igualdad estructural. ¿Es c igual a d? ${c==d}") //true
        Log.i("CASE-OPER","Igualdad estructural. ¿Es d igual a e? ${d==e}") //false
    }


    data class FiguraV2 (val nombre : String)
}