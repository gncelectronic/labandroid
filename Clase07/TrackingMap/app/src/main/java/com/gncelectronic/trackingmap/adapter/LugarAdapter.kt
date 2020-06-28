package com.gncelectronic.trackingmap.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.gncelectronic.trackingmap.R
import com.gncelectronic.trackingmap.model.Lugar
import kotlinx.android.synthetic.main.lugar_list_layout.view.*

class LugarAdapter(private val context: Activity, private val lugarList : ArrayList<Lugar>):
    ArrayAdapter<Lugar>(context, R.layout.lugar_list_layout, lugarList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater= context.layoutInflater
        val viewPersonalizada = layoutInflater.inflate(R.layout.lugar_list_layout,null,true)
        viewPersonalizada.listRowTextView.text= lugarList.get(position).direccion
        return viewPersonalizada
    }


}