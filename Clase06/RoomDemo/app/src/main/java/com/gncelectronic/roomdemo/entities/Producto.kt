package com.gncelectronic.roomdemo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

/**
 * Entidad Producto
 */
@Entity(tableName = "productos")
class Producto {

    @PrimaryKey(autoGenerate=true)
    @NotNull
    @ColumnInfo(name="prod_id")
    var id : Int =0

    @ColumnInfo(name="prod_nombre")
    var productoNombre:String?=null


    var cantidad: Int =0
    constructor() {}

    constructor( id:Int, productoNombre:String, cantidad:Int){
        this.id = id
        this.productoNombre = productoNombre
        this.cantidad=cantidad
    }

    constructor(productoNombre: String, cantidad: Int){
        this.productoNombre = productoNombre
        this.cantidad = cantidad
    }

}