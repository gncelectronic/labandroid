package com.gncelectronic.roomdemo.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gncelectronic.roomdemo.R
import com.gncelectronic.roomdemo.entities.Producto
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*

class MainFragment : Fragment() {
private var adapter: ProductoListAdapter? =null
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        listenerSetup() //ok
        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup() {
       addButton.setOnClickListener {

           val name = productName.text.toString()
           val quantity = productQuantity.text.toString()

           if(name!="" && quantity != ""){
               val product = Producto(name, Integer.parseInt(quantity))
               viewModel.insertProducto(product)
               clearFields()
           }else{
               productID.text="Información incompleta"
           }
       }


        findButton.setOnClickListener {

            viewModel.findProducto(productName.text.toString())
        }

        deleteButton.setOnClickListener {

            viewModel.deleteProducto(productName.text.toString())
            clearFields()
        }
    }

    private fun observerSetup() {
        viewModel.getAllProductos()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            products -> products?.let{
            adapter?.setProductList(it)
        }
        })


       viewModel.getSearchResults().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
           products -> products?.let{
           if(it.isNotEmpty()){
               productID.text = String.format(Locale.US, "%d", it[0].id)
               productName.setText(it[0].productoNombre)
               productQuantity.setText(String.format(Locale.US, "%d", it[0].cantidad))
           }else{
               productID.text="No coincide con la busqueda"
           }

       }
       })
    }

    private fun recyclerSetup() {
       adapter = ProductoListAdapter(R.layout.product_list_item)
       val recyclerView : RecyclerView?= product_recycler
        recyclerView?.layoutManager=LinearLayoutManager(context)
        recyclerView?.adapter=adapter
    }





    /**
     * Limpia los campos  de IU
     */
    private fun clearFields(){
        productID.text =""
        productName.setText("")
        productQuantity.setText("")
    }

}
