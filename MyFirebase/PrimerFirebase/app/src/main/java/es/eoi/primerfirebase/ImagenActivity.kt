package es.eoi.primerfirebase

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class ImagenActivity : AppCompatActivity() {

    // UDEMY: Android y Kotlin Desde Cero a Profesional Completo +45 horas: Sección 23 - Cámara
    // VA JUNTO A LA CLASE: Fotos.kt , res>xml>my_images.xml
    var fotos: Fotos? = null
    var ivFoto: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)

        val bTomar = findViewById<Button>(R.id.bTomar)
        val bSeleccionar = findViewById<Button>(R.id.bSeleccionar)

        ivFoto = findViewById(R.id.ivFoto)

        fotos = Fotos(this, ivFoto!!)

        bTomar.setOnClickListener {

            //dispararIntentTomarFoto()
            fotos?.tomarFoto()
        }

        bSeleccionar.setOnClickListener {
            fotos?.seleccionarFoto()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //requestPermissionsResult(requestCode, permissions, grantResults)
        fotos?.requestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //activityResult(requestCode, resultCode, data)
        fotos?.activityResult(requestCode, resultCode, data)
    }

}