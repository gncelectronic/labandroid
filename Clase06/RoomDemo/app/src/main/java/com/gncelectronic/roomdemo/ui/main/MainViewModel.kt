package com.gncelectronic.roomdemo.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.gncelectronic.roomdemo.entities.Producto
import com.gncelectronic.roomdemo.respositories.ProductoRepository

class MainViewModel(application : Application) : AndroidViewModel(application) {
  private val repository:ProductoRepository = ProductoRepository((application))
  private val allProductos : LiveData<List<Producto>>?
  private val searchResults: MutableLiveData<List<Producto>>

    init {
        allProductos = repository.allProducto
        searchResults = repository.searchResults
    }

    /**
     * Agrega un producto
     */
    fun insertProducto(producto: Producto){
        repository.insertProducto(producto)
    }

    fun findProducto(name:String){
        repository.findProducto(name)
    }

    fun deleteProducto(name: String){
        repository.deleteProducto(name)
    }

    fun getSearchResults():MutableLiveData<List<Producto>>{
        return searchResults
    }

    fun getAllProductos():LiveData<List<Producto>>?{
        return allProductos
    }


}
