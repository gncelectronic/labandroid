package com.gncelectronic.trackingmap

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gncelectronic.trackingmap.model.Lugar

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Exception
import java.util.*
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    var locationManager:LocationManager?= null
    var locationListener: LocationListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intentToMainActivity =  Intent(this,MainActivity::class.java)
        startActivity(intentToMainActivity)
        finish()

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnMapLongClickListener(myListener)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = object : LocationListener{
            override fun onLocationChanged(location: Location?) {

             if(location !=null){
                 val sharedPreferences = applicationContext.getSharedPreferences("TrackingMap",Context.MODE_PRIVATE)
                 val firstTimeCheck = sharedPreferences.getBoolean("notFirstTime",false)
                 if (!firstTimeCheck){
                     var ubicacionUsuario = LatLng(location!!.latitude,location!!.longitude)
                   //  mMap.addMarker(MarkerOptions().position(ubicacionUsuario).title("Mi Uibicación"))
                     mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionUsuario,15f))
                     sharedPreferences.edit().putBoolean("notFirstTime",true).apply()
                 }
             }


            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                TODO("Not yet implemented")
            }

            override fun onProviderEnabled(provider: String?) {
                TODO("Not yet implemented")
            }

            override fun onProviderDisabled(provider: String?) {
                TODO("Not yet implemented")
            }

        }

        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1)
        }
        else{
            locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER,2,2f,locationListener)
            val intent = intent
            val info = intent.getStringExtra("info")

            if(info.equals("new") ){

                val ultimaUbicacion= locationManager!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if(ultimaUbicacion !=null) {
                    var ultimaUbicacionUsuario =
                        LatLng(ultimaUbicacion.latitude, ultimaUbicacion.longitude)
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ultimaUbicacionUsuario, 15f))
                }
            }
            // si es recuperado de la BD es old
            else{
                mMap.clear()
                val lugarSeleccionado = intent.getSerializableExtra("lugarSeleccionado") as Lugar
                val coordenadas = LatLng(lugarSeleccionado.latitud!!, lugarSeleccionado.longitud!!)


                mMap.addMarker(MarkerOptions().position(coordenadas).title(lugarSeleccionado.direccion))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,15f))
            }
        }

    }

    private val myListener = GoogleMap.OnMapLongClickListener { p0 ->
        val geocoder = Geocoder(applicationContext, Locale.getDefault())
        var direccion=""
        try{
            val listaDirecc= geocoder.getFromLocation(p0!!.latitude,p0!!.longitude,1)
            if(listaDirecc[0].thoroughfare != null){
                direccion += listaDirecc[0].thoroughfare
                if(listaDirecc[0].subThoroughfare != null){
                    direccion += listaDirecc[0].subThoroughfare
                }
            } else{
                direccion = "Nuevo Lugar"
            }
        }catch(e: Exception){
            e.printStackTrace()
        }
        mMap.clear()
        mMap.addMarker(MarkerOptions().position(p0!!).title(direccion))
        Toast.makeText(applicationContext,"Nuevo lugar creado",Toast.LENGTH_LONG).show()

        /**
         * Creación de la base de datos para guardar las coordenadas de los lugares seleccionados.
         */

        /**
         * Creación de la base de datos para guardar las coordenadas de los lugares seleccionados.
         */
        try{
            val latitud = p0.latitude.toString()
            val longitud= p0.longitude.toString()
            val database = openOrCreateDatabase("Lugares",Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS lugares( nombre VARCHAR," +
                    "latitud DOUBLE, longitud DOUBLE)")
            val toCompile = "INSERT INTO lugares (nombre, latitud, longitud) VALUES(?,?,?)"
            val sqlLiteStatement = database.compileStatement(toCompile)
            sqlLiteStatement.bindString(1,direccion)
            sqlLiteStatement.bindString(2,latitud)
            sqlLiteStatement.bindString(3,longitud)
            sqlLiteStatement.execute()
        }catch(e: Exception){
            e.printStackTrace()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(grantResults.size>0){
            if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER,2,2f,locationListener)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
