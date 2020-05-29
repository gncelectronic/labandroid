package com.gncelectronic.logcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener{mostrarMensaje()}
    }

    private fun mostrarMensaje(){
        Log.i("MAIN_ACTIVITY","Login es: ${editTextLogin.text}, la password es:  ${editTextPass.text}")
    }
}
