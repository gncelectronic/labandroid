package com.gncelectronic.kotlinfundapp.ejemplos
/**
 * https://kotlinlang.org/docs/reference/visibility-modifiers.html
 * Para hacer una clase extensible o heredable tenemos que marcarlo como open
 * En Java es open por defecto y en Kotlin es final por defecto, asi que no puede ser extendida sin el uso de open
 */
open class HerenciaModAcc {
    //private      -- solo visible dentro de la clase
    // protected   -- solo visible dentro de la clase y de sus subclases (Herencia)
    //public       -- visible dentro de la clase, de sus sublcases y desde afuera.

    val prop1 = "public y default"
    private val prop2 ="privada"
    protected  val prop3 = "protected"

    private fun algunMetodo(){
        val test = HerenciaModAcc()
        test.prop1
    }


}

class ClaseHija : HerenciaModAcc(){
    private fun algunMetodo(){
        prop1
        this.prop1
        //prop2 no es accesible
        prop3
    }

  class OtraClase {
      private fun algunMetodo(){
          val test = HerenciaModAcc()

      }
  }
}