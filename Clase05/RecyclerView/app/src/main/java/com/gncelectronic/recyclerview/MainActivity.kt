package com.gncelectronic.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gncelectronic.recyclerview.adaptadores.PersonaAdaptador
import com.gncelectronic.recyclerview.models.Persona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var  personaList: List<Persona>
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<PersonaAdaptador.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1)Especifico el tipo de Manager a utilizar en el recyclerView en este caso un LineLayout
        layoutManager = LinearLayoutManager(this)
        //Si quiero usar un Grid Layout
        //layoutManager = GridLayoutManager(this,2)
        //2) asigno  a mi recycleView el manager layout
        recyclerViewID.layoutManager = layoutManager

        //3) Obtenemos la lista de personas
        personaList =getPersonas()

        //4) inicializamos el adaptador
        adapter = PersonaAdaptador(personaList)
        recyclerViewID.adapter = adapter
    }

    /**
     * Simular que viene de una Base de datos o una API
      */
private fun getPersonas():List<Persona> {
    return listOf(
        Persona("Gaston", "Cangemi", 40, R.drawable.android_image_1),
        Persona("Jorge", "Rojas", 33, R.drawable.android_image_2),
        Persona("Enrique", "Lopez", 38, R.drawable.android_image_3),
        Persona("Elena", "Gutierrez", 25, R.drawable.android_image_4),
        Persona("Miguel", "Mendez", 38, R.drawable.android_image_5),
        Persona("Raul", "Pereyra", 55, R.drawable.android_image_6),
        Persona("Fabian", "Calle", 26, R.drawable.android_image_7),
        Persona("Amalia", "Robles", 34, R.drawable.android_image_8),
        Persona("Marta", "Martini", 18, R.drawable.android_image_1),
        Persona("Julio", "Gomez", 50, R.drawable.android_image_2),
        Persona("Rodolfo", "Soler", 36, R.drawable.android_image_3),
        Persona("Agusto", "Arguello", 38, R.drawable.android_image_4),
        Persona("Tatiana", "Rivarola", 36, R.drawable.android_image_5),
        Persona("Angel", "Rodriguez", 28, R.drawable.android_image_6),
        Persona("Cintia", "Puebla", 31, R.drawable.android_image_7),
        Persona("Jorgelina", "Ross", 25, R.drawable.android_image_8),
        Persona("Sofia", "Mansur", 23, R.drawable.android_image_1),
        Persona("Ines", "Antich", 27, R.drawable.android_image_2),
        Persona("Francisco", "Gil", 22, R.drawable.android_image_3),
        Persona("Walter", "Rivas", 21, R.drawable.android_image_4),
        Persona("Eugenio", "Porta", 33, R.drawable.android_image_5),
        Persona("Emilio", "Carreras", 42, R.drawable.android_image_6),
        Persona("Victor", "Ferreyra", 53, R.drawable.android_image_7),
        Persona("Mirtha", "Legrand", 99, R.drawable.android_image_8),
        Persona("Julian", "Chivas", 66, R.drawable.android_image_1),
        Persona("Alberto", "Olmos", 44, R.drawable.android_image_2),
        Persona("Jonathan", "Tobares", 31, R.drawable.android_image_3),
        Persona("Maria", "Escobar", 22, R.drawable.android_image_4)
    )
}
}
