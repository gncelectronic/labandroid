package com.gncelectronic.conversorlivedata.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gncelectronic.conversorlivedata.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
      //Implementación de un observador, donde resultObserver
        val resultObserver = Observer<Float>{
            result -> textViewResultado.text = result.toString()
        }

        viewModel.obtenerConversion().observe(this,resultObserver)


        btnConvertir.setOnClickListener {
          if(editTextMonto.text.isNotEmpty()) {
              viewModel.convertirMonto(editTextMonto.text.toString())
          }else{

              textViewResultado.text="Ingrese un valor en USD"
          }
        }

    }

}
