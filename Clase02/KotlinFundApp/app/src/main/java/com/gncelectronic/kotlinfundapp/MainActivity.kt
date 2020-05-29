package com.gncelectronic.kotlinfundapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.gncelectronic.kotlinfundapp.ejemplos.ControlFlujo
import com.gncelectronic.kotlinfundapp.ejemplos.NullAble
import com.gncelectronic.kotlinfundapp.ejemplos.Operadores
import com.gncelectronic.kotlinfundapp.ejemplos.Variables
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var command = arrayOf("logcat","-d","tag","CASE-OPER")
        val process = Runtime.getRuntime().exec(command)
        val bufferedReader = BufferedReader(
            InputStreamReader(process.inputStream)
        )
        val log = StringBuilder()
        var line: String? = ""
        while (bufferedReader.readLine().also { line = it } != null) {
            log.append(line)
        }


        Variables().workInteger()
        Variables().workLong()
        Variables().workFloat()
        Variables().workDouble()
        Variables().workChar()
        Variables().workString()
        Variables().workArrays()
        ControlFlujo().workIfExpression()
        ControlFlujo().workWhen()
        ControlFlujo().workFor()
        ControlFlujo().worWhileDoWhile()
        Operadores().workEquals()
        Operadores().workEqualsDataClass()

        //  NullAble().workNPE()
         NullAble().workOnlySafe(null)
        //NullAble().workcallJavaClass()
        //  NullAble().workWrongIni()

        textView.text =log.toString()
        textView.movementMethod = ScrollingMovementMethod();

    }
}
