package com.gncelectronic.ciclovidaactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("LOG-ACTIVITY", "Entrando al método onCreate()")
    }


    override fun onStart() {
        super.onStart()
        Log.i("LOG-ACTIVITY", "Entrando al método onStart()")
    }


    override fun onResume() {
        super.onResume()
        Log.i("LOG-ACTIVITY", "Entrando al método onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LOG-ACTIVITY", "Entrando al método onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LOG-ACTIVITY", "Entrando al método onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LOG-ACTIVITY", "Entrando al método onDestroy()")
        Toast.makeText(this,"entrando a onDestroy()",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LOG-ACTIVITY", "Entrando al método onRestart()")
    }
}
