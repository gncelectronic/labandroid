package com.gncelectronic.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { llamarActivity() }
        button2.setOnClickListener { openURL() }


    }



    private fun llamarActivity() {
       var intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("KEY_NAME","GASTON")
        startActivity(intent)
    }

    private fun openURL() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.campusvirtual.frm.utn.edu.ar"))
       // Verifica que el intent se resuelva en una actividad
        if(intent.resolveActivity(packageManager)!=null){
            startActivity(intent)
        }

    }
}
