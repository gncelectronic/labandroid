package com.gncelectronic.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gncelectronic.roomdemo.dao.ProductoDAO
import com.gncelectronic.roomdemo.entities.Producto
import kotlin.coroutines.coroutineContext

@Database(entities = [Producto::class],version = 1)
abstract class ProductoRoomDatabase : RoomDatabase() {

    abstract fun productoDAO(): ProductoDAO

    companion object {
        private var INSTANCE: ProductoRoomDatabase? = null
      internal fun getDatabase(context: Context): ProductoRoomDatabase?{
        if(INSTANCE == null)
        {
            kotlin.synchronized(ProductoRoomDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder<ProductoRoomDatabase>(
                        context.applicationContext,
                        ProductoRoomDatabase::class.java,
                        "producto_database"
                    ).build()
                }
            }
        }
        return INSTANCE
    }
}
}