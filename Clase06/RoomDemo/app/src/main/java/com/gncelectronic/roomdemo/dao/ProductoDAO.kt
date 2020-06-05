package com.gncelectronic.roomdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gncelectronic.roomdemo.entities.Producto

/**
 * DAO de la Entidad Producto
 */
@Dao
interface ProductoDAO {

    @Insert
    fun insertProducto(producto: Producto)

    /**
     * Busca todos los productos por nombre
     */
    @Query("SELECT * FROM productos WHERE prod_nombre= :nombre")
    fun findProducto(nombre : String):List<Producto>

    @Query("DELETE FROM productos WHERE prod_nombre = :nombre")
    fun deleteProducto(nombre: String)

    @Query("SELECT * FROM productos")
    fun getAllProductos():LiveData<List<Producto>>
}