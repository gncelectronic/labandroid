package com.gncelectronic.kotlinfundapp.ejemplos

class Figura(val nombre :String ) {

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Figura){
            return false
        }

        return nombre == other.nombre
    }

}