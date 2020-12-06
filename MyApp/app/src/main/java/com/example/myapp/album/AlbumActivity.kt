package com.example.myapp.album

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    private lateinit var adapter: AlbumAdapter
    private lateinit var albums: java.util.ArrayList<Album>
    private lateinit var albumsTotales: java.util.ArrayList<Album>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        setSupportActionBar(toolbar)
        albums = generarAlbums()
        albumsTotales= generarAlbums()
        adapter=AlbumAdapter(albums){
            val intent= Intent(this, AlbumDetalleActivity::class.java)
            intent.putExtra("album",it)
            startActivity(intent)

            Log.w("AlbumActivity",it.toString())
        }
        recyclerAlbum.adapter=adapter
        recyclerAlbum.layoutManager=GridLayoutManager(this,2)
    }

    fun generarAlbums():ArrayList<Album>{
        val data= arrayListOf<Album>()
        data.add(
            Album(
                "Citadel",
                2014,
                "https://upload.wikimedia.org/wikipedia/en/2/2c/Ne_Obliviscaris_Citadel.jpg",
                6
            )
        )
        data.add(
            Album(
                "Urn",
                2013,
                "https://upload.wikimedia.org/wikipedia/en/b/be/Ne_Obliviscaris_Urn_cover_art.jpg",
                6
            )
        )
        data.add(
            Album(
                "Portal of I",
                2017,
                "https://images-na.ssl-images-amazon.com/images/I/71AQt5rx3JL._SL1200_.jpg",
                6
            )
        )
        return data
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchView = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        searchView.setOnCloseListener {
            albums.clear()
            albums.addAll(albumsTotales)
            adapter.data=albums
            adapter.notifyDataSetChanged()
            false
        }
        val queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(textoEscrito: String?): Boolean {
            //TODO Cuando se pulsa en el boton de buscar del teclado entra aqui
                if (textoEscrito != null) {
                    albums=albumsTotales.filter {
                        it.nombre.contains(
                            textoEscrito,
                            true
                        )
                    }
                            as ArrayList<Album>
                    adapter.data = albums
                    adapter.notifyDataSetChanged()
                }
                return false
            }
            override fun onQueryTextChange(textoEscrito: String?): Boolean {
            //TODO Cada vez que escribimos una letra entra aqui
                if (textoEscrito != null) {
                    albums = albumsTotales.filter {
                        it.nombre.contains(
                            textoEscrito,
                            true
                        )
                    }
                            as ArrayList<Album>
                    adapter.data = albums
                    adapter.notifyDataSetChanged()
                }
                    return false
            }
        }
        searchView.setOnQueryTextListener(queryTextListener)
        return super.onCreateOptionsMenu(menu)
    }
}
