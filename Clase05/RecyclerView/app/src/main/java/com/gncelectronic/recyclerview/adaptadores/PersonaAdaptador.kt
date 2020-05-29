package com.gncelectronic.recyclerview.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gncelectronic.recyclerview.R
import com.gncelectronic.recyclerview.models.Persona
import kotlinx.android.synthetic.main.recycler_persona.view.*

class PersonaAdaptador(val listaPersonas:List<Persona>): RecyclerView.Adapter<PersonaAdaptador.ViewHolder>() {



inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var foto: ImageView
    var nombreCompleto :TextView
    var edad:TextView

    init {
        foto = itemView.imageViewFoto
        nombreCompleto = itemView.textViewNombre
        edad= itemView.textViewEdad
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_persona,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombreCompleto.text="${listaPersonas[position].nombre}, ${listaPersonas[position].apellido}"
        holder.edad.text="${listaPersonas[position].edad}"
        holder.foto.setImageResource(listaPersonas[position].fotoRef)
    }

}