package com.gncelectronic.conversorviewmodel.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gncelectronic.conversorviewmodel.R
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
       textViewResultado.text = viewModel.obtenerConversion().toString()
        btnConvertir.setOnClickListener {

            if(editTextMonto.text.isNotEmpty()){
                viewModel.convertirMonto(editTextMonto.text.toString())
                textViewResultado.text = viewModel.obtenerConversion().toString()
            }else{
                textViewResultado.text="Ingrese un valor en USD."
            }


        }
    }

}
