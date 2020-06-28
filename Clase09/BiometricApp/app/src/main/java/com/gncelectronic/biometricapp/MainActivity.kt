package com.gncelectronic.biometricapp

import android.app.ActionBar
import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private var cancellationSignal: CancellationSignal? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      btnAutentificar.setOnClickListener { autentificarUsuario()}

    }

    private fun notificarUsuario(mensaje:String){
        Toast.makeText(this,
        mensaje,Toast.LENGTH_LONG).show()
        checkBiometricSupport()

    }


    private fun checkBiometricSupport() :Boolean {
        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (!keyguardManager.isKeyguardSecure) {
            notificarUsuario("La seguridad de Bloquear pantalla no esta habilitada en Configuraciones.")
        }

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.USE_BIOMETRIC)
                != PackageManager.PERMISSION_GRANTED) {
            notificarUsuario("Permisos biometricos no habilitados.")
            return false
        }
        return if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            true
        } else true
    }

    /**
     * Callback
     */
    private val authenticationCallback:BiometricPrompt.AuthenticationCallback
        get() = object: BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {

                notificarUsuario("Error de autentificación: $errString")
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                super.onAuthenticationHelp(helpCode, helpString)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
               notificarUsuario("Autentificación satisfactoria")
                super.onAuthenticationSucceeded(result)
            }
        }

    /**
     * Callback  CancellationSignal
     */

    private fun getCancellationSignal():CancellationSignal{
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notificarUsuario("Cancelación via signal")
        }
        return cancellationSignal as CancellationSignal
    }


    private fun autentificarUsuario(){
     val biometricPrompt = BiometricPrompt.Builder(this)
             .setTitle("Demo autentificación Biometrica")
             .setSubtitle("La autentificación es requerida para continuar")
             .setDescription("Esta app usa autentificación biometrica para protejer tus datos")
             .setNegativeButton("Cancelar",this.mainExecutor,DialogInterface.OnClickListener{
                 dialogInterface, i ->
                 notificarUsuario("Autentificación Cancelada")}).build()
        biometricPrompt.authenticate(getCancellationSignal(),mainExecutor,authenticationCallback)
    }

}
