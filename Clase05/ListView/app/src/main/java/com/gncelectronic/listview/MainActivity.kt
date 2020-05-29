package com.gncelectronic.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gncelectronic.listview.adaptadores.PersonaAdaptador
import com.gncelectronic.listview.models.Persona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var  personaAdaptador: PersonaAdaptador
    private lateinit var  listaPersona: List<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listaPersona = getPersonas()
        //Inicializamos el adaptador de Personas
        personaAdaptador = PersonaAdaptador(this, R.layout.list_view_persona,listaPersona)
        //Cargamos el adaptador al listView
        listView.adapter = personaAdaptador
    }


    private fun getPersonas():List<Persona>{
        return listOf(
            Persona("Gaston", "Cangemi",41),
            Persona("Jorge", "Rosales",33),
            Persona("Enrique", "Lopez",38),
            Persona("Federico", "Baez",55),
            Persona("Federico", "Paez",23),
            Persona("Marta", "Robles",56),
            Persona("Maria", "Angeliz",23),
            Persona("Gabriela", "Rivarola",24),
            Persona("Julio", "Sanchez", 56),
            Persona("Romina", "Lagos",33),
            Persona("Tatiana", "Fernandez",41),
            Persona("Walter", "Rivas", 21),
            Persona("Eugenio", "Porta", 33),
            Persona("Emilio", "Carreras", 42),
            Persona("Victor", "Ferreyra", 53),
            Persona("Mirtha", "Legrand", 99),
            Persona("Julian", "Chivas", 66),
            Persona("Alberto", "Olmos", 44),
            Persona("Jonathan", "Tobares", 31),
            Persona("Maria", "Escobar", 22)

        )
    }
}
