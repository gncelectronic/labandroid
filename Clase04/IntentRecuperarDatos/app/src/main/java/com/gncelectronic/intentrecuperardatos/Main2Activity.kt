package com.gncelectronic.intentrecuperardatos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    companion object{
        val KEY_NOMBRE="NOMBRE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btnRegistrar.setOnClickListener { registrar() }
    }

    private fun registrar() {
       val nombre = editText.text.toString()
        if(nombre.isEmpty()){
            setResult(Activity.RESULT_CANCELED)
        }else{
            val result = Intent()
            result.putExtra(KEY_NOMBRE,nombre)
            setResult(Activity.RESULT_OK,result)

        }
        finish()
    }
}
