package com.gncelectronic.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val extra = intent.extras
        if(extra != null){
            val nombre = extra.getString("KEY_NAME")
            textView.text = nombre
        }
    }
}
