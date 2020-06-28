package com.gncelectronic.climaapp01.api

import com.gncelectronic.climaapp01.modelo.ClimaActual
import org.json.JSONObject

class JSONParser {
    fun getClimaActualFromJson(response: JSONObject):ClimaActual{
        val currentJSON = response.getJSONObject("currently")
        with(currentJSON){
           val climaActual = ClimaActual(
               icon =getString("icon"),
               summary = getString("summary"),
               temperature = getDouble("temperature"),
               precipProb = getDouble("precipProbability")
           )
       return climaActual
        }
    }
}