package com.gncelectronic.appmostrarimagenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//Arreglo que almacena las imagenes a mostrar
private val images = arrayOf(R.drawable.android1,R.drawable.android2, R.drawable.android3, R.drawable.android4)
private var currImage = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun  cambiarImagen(view: View){
       currImage = currImage.inc()
        if(currImage == images.size){
            currImage=0
        }
        setCurrentImage()
    }

    private fun setCurrentImage() {
        val imageView = findViewById<ImageView>(R.id.imagenDisplay)
        imageView.setImageResource(images[currImage])

    }
}
