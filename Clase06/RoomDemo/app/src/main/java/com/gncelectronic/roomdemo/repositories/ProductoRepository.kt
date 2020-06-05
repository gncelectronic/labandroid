package com.gncelectronic.roomdemo.repositories

import android.app.Application
import android.os.AsyncTask
import android.os.Trace
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gncelectronic.roomdemo.dao.ProductoDAO
import com.gncelectronic.roomdemo.db.ProductoRoomDatabase
import com.gncelectronic.roomdemo.entities.Producto

class ProductoRepository(application: Application) {

    val searchResults = MutableLiveData<List<Producto>>()
    private var  productoDAO : ProductoDAO?
    val allProductos: LiveData<List<Producto>>?

    init {
        val db : ProductoRoomDatabase ? = ProductoRoomDatabase.getDatabase(application)
        productoDAO = db?.productoDAO()
        allProductos = productoDAO?.getAllProductos()

    }

    fun  asyncFinished(results:List<Producto>){
        searchResults.value=results
    }

    fun insertProduct(newproduct: Producto) {
        val task = InsertAsyncTask(productoDAO)
        task.execute(newproduct)
    }

    fun deleteProduct(nombre: String) {
        val task = DeleteAsyncTask(productoDAO)
        task.execute(nombre)
    }

    fun findProduct(nombre: String) {
        val task = QueryAsyncTask(productoDAO)
        task.delegate = this
        task.execute(nombre)
    }


    private class QueryAsyncTask constructor(val asynkTaskDao: ProductoDAO?):
      AsyncTask<String, Void, List<Producto>>(){
      var delegate:ProductoRepository?=null

      override fun doInBackground(vararg params: String): List<Producto>? {
         return asynkTaskDao?.findProducto(params[0])
      }

      override fun onPostExecute(result: List<Producto>) {
            delegate?.asyncFinished(result)
      }

  }

    private class InsertAsyncTask constructor(private val asyncTaskDao: ProductoDAO?) : AsyncTask<Producto, Void, Void>() {

        override fun doInBackground(vararg params: Producto): Void? {
            asyncTaskDao?.insertProducto(params[0])
            return null
        }
    }

    private class DeleteAsyncTask constructor(private val asyncTaskDao: ProductoDAO?) : AsyncTask<String, Void, Void>() {

        override fun doInBackground(vararg params: String): Void? {
            asyncTaskDao?.deleteProducto(params[0])
            return null
        }
    }


}