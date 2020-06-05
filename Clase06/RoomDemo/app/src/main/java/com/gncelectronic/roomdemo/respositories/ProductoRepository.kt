package com.gncelectronic.roomdemo.respositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gncelectronic.roomdemo.dao.ProductoDAO
import com.gncelectronic.roomdemo.db.ProductoRoomDatabase
import com.gncelectronic.roomdemo.entities.Producto

class ProductoRepository(application: Application) {
    val searchResults = MutableLiveData<List<Producto>>()
    var  productoDAO : ProductoDAO ?
    val allProducto: LiveData<List<Producto>>?

    init{
        val db : ProductoRoomDatabase? = ProductoRoomDatabase.getDatabase(application)
        productoDAO = db?.productoDAO()
        allProducto = productoDAO?.getAllProductos()
    }


    fun asyncFinished(results :List<Producto>){
        searchResults.value=results
    }

    /**
     * Igrega un producto a la tabla productos de forma asincronica
     */
    fun insertProducto(newProduct : Producto){
        val task = InsertAsyncTask(productoDAO)
        task.execute(newProduct)
    }

    fun deleteProducto(nombre: String){
        val task = DeleteAsyncTask(productoDAO)
        task.execute(nombre)
    }


    fun findProducto(nombre: String){
        val task = QueryAsyncTask(productoDAO)
        task.delegate= this
        task.execute(nombre)
    }





    private class QueryAsyncTask constructor(private val asyncTaskDao: ProductoDAO?): AsyncTask<String, Void, List<Producto>>(){
        var delegate : ProductoRepository? = null
        override fun doInBackground(vararg params: String): List<Producto>? {
           return asyncTaskDao?.findProducto(params[0])
        }

        override fun onPostExecute(result: List<Producto>) {
            delegate?.asyncFinished(result)
        }

    }




    private class InsertAsyncTask constructor(private val asyncTaskDao: ProductoDAO?) :AsyncTask<Producto, Void,Void>(){
        override fun doInBackground(vararg params: Producto): Void? {
           asyncTaskDao?.insertProducto(params[0])
            return null
        }

    }


    private class DeleteAsyncTask constructor(private val asyncTaskDao: ProductoDAO?) : AsyncTask<String, Void, Void>(){
        override fun doInBackground(vararg params: String): Void? {
            asyncTaskDao?.deleteProducto(params[0])
            return null
        }

    }

}