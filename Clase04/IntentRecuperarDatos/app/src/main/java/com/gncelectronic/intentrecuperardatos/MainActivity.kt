package com.gncelectronic.intentrecuperardatos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //codigo de llamada para identificar la llamada
    val CODIGO_LLAMADA =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPedirNombre.setOnClickListener { llamarActivity() }
    }

    private fun llamarActivity() {
        val intent = Intent(this,Main2Activity::class.java)
        startActivityForResult(intent,CODIGO_LLAMADA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            CODIGO_LLAMADA ->{
                if(resultCode == Activity.RESULT_OK){
                    val nombre  = data?.getStringExtra(Main2Activity.KEY_NOMBRE)
                    textView.text = nombre
                    Toast.makeText(this, nombre,Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "NOMBRE VACIO",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
