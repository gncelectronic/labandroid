package com.gncelectronic.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gncelectronic.roomdemo.R
import com.gncelectronic.roomdemo.entities.Producto
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductoListAdapter(private val productItemLayout: Int):RecyclerView.Adapter<ProductoListAdapter.ViewHolder>() {

    private var productList:List<Producto>? = null

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var item: TextView = itemView.findViewById(R.id.product_row)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate( productItemLayout, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(productList == null) 0 else productList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = holder.item
        productList.let {

            item.text = it!![position].productoNombre
        }
    }


    fun setProductList(products : List<Producto>){
        productList = products
        notifyDataSetChanged()
    }
}