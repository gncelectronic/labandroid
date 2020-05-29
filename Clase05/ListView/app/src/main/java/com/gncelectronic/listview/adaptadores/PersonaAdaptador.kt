package com.gncelectronic.listview.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gncelectronic.listview.models.Persona
import kotlinx.android.synthetic.main.list_view_persona.view.*

class PersonaAdaptador(val context:Context, val layout:Int, val listaPersonas: List<Persona>):BaseAdapter() {

    private val miInflator : LayoutInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view: View
       val vh: PersonaViewHolder

       if(convertView == null){
        view = miInflator.inflate(layout,parent,false)
           vh = PersonaViewHolder(view)
           view.tag =vh
       }else{
           view = convertView
           vh = view.tag as PersonaViewHolder
       }
        val nombreCompleto ="${listaPersonas[position].nombre}, ${listaPersonas[position].apellido}"
        //Rellenamos el nombre completo y la edad
        vh.nombreCompleto.text = nombreCompleto
        vh.edad.text = "${listaPersonas[position].edad}"

        return view
    }

    override fun getItem(position: Int): Any {
        return listaPersonas[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getCount(): Int {
       return listaPersonas.size
    }

    /**
     * Patron de diseño ViewHolder
     */
    private  class  PersonaViewHolder(view: View){
        val nombreCompleto :TextView = view.nombreCompleto
        val edad: TextView = view.edad
    }


}