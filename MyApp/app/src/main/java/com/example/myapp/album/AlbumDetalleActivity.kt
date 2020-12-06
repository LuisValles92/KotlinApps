package com.example.myapp.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album_detalle.*
import kotlinx.android.synthetic.main.activity_album_detalle.tvName
import kotlinx.android.synthetic.main.item_album.*
import kotlinx.android.synthetic.main.item_album.view.*
import kotlinx.android.synthetic.main.activity_album_detalle.ivAlbum as ivAlbum1

class AlbumDetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detalle)

        val albumSeleccionado =intent?.extras?.getSerializable("album")as Album

        tvName.text = albumSeleccionado.nombre
        tvYear.text = "${albumSeleccionado.anio} - ${albumSeleccionado.canciones}"
        if (!albumSeleccionado.imagen.isNullOrEmpty()) {
            Picasso.get().load(albumSeleccionado.imagen).into(ivAlbum)
        }
    }
}
