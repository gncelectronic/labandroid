package com.gncelectronic.appshowimages02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    //Arreglo que almacena  las imagenes a mostrar
    private val images = arrayOf(R.drawable.android1, R.drawable.android2, R.drawable.android3, R.drawable.android4)
    //Variable que lleva el indice de la imagen actual
    var currImage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Funcion que se activa cuando se  toca el boton Cambiar
     */
    fun changeImages(view: View) {
        currImage = currImage.inc()
        if (currImage == images.size) {
            currImage = 0
        }
        setCurrentImage()
    }

    /**
     * Establece la imagen  en el componente ImageView
     */
    private fun setCurrentImage() {
        val imageView = findViewById<ImageView>(R.id.imageDisplay)
        imageView.setImageResource(images[currImage])

    }
}
