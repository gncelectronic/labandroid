package com.gncelectronic.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.get().load("https://www.pexels.com/photo/autumn-colors-3070989/").fetch()
        btnCargarImagen.setOnClickListener { cargarImagenes() }
        btnLoaderResize.setOnClickListener { cargarImagenesRedimensionadas() }
        btnLoaderCircle.setOnClickListener { cargarImagenesEnCirculos() }
        btnLoaderAnimation.setOnClickListener { cargarImagenesConAnimacion() }
    }



    private fun cargarImagenes() {
        Picasso.get()
            .load("https://images.pexels.com/photos/3070989/pexels-photo-3070989.jpeg")
            .fit() //llenar entera la imagen
            .into(imageViewTop)

        Picasso.get()
            .load("https://images.pexels.com/photos/545014/pexels-photo-545014.jpeg")
            .fit() //llenar entero el ImageView
            .into(imageViewBottom)

    }


    private fun cargarImagenesRedimensionadas() {
        Picasso.get()
            .load("https://images.pexels.com/photos/3070989/pexels-photo-3070989.jpeg")
            .resize(300, 300)
            .centerCrop()
            .into(imageViewTop)


        Picasso.get()
            .load("https://images.pexels.com/photos/545014/pexels-photo-545014.jpeg")
            .resize(300, 300)
            .centerInside()
            .into(imageViewBottom)
    }


    private fun cargarImagenesEnCirculos(){
        Picasso.get()
            .load("https://images.pexels.com/photos/3070989/pexels-photo-3070989.jpeg")
            .fit()
            .transform(CircleTransform())
            .into(imageViewTop)

        Picasso.get()
            .load("https://images.pexels.com/photos/545014/pexels-photo-545014.jpeg")
            .fit()
            .transform(CircleTransform())
            .into(imageViewBottom)
    }

    private fun cargarImagenesConAnimacion(){
        Picasso.get()
            .load("https://images.pexels.com/photos/3070989/pexels-photo-3070989.jpeg")
            .fetch(object: Callback{
                override fun onSuccess() {
                    imageViewTop.alpha =0f
                    Picasso.get()
                        .load("https://images.pexels.com/photos/3070989/pexels-photo-3070989.jpeg")
                        .fit()
                        .into(imageViewTop)

                    imageViewTop.animate().setDuration(3000).alpha(1f).start()
                }

                override fun onError(e: Exception?) {
                    Log.e("ERROR-ANIMATION", e.toString())
                }
            })


        Picasso.get()
            .load("https://images.pexels.com/photos/3957982/pexels-photo-3957982.jpeg")
            .fetch(object: Callback{
                override fun onSuccess() {
                    imageViewBottom.alpha =0f
                    Picasso.get()
                        .load("https://images.pexels.com/photos/3957982/pexels-photo-3957982.jpeg")
                        .fit()
                        .into(imageViewBottom)

                    imageViewBottom.animate().setDuration(3000).alpha(1f).start()
                }

                override fun onError(e: Exception?) {
                   Log.e("ERROR-ANIMATION", e.toString())
                }
            })

    }


}
