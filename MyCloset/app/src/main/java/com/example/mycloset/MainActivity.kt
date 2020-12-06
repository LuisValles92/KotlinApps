package com.example.mycloset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mycloset.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    //val CITY: String = "valladolid,es"
    //val API: String = "8118ed6ee68db2debfaaa5a44c832918"
    val API: String = "4902fb00d210ac7d5006e42f6803016c"
    val LAT: String = "41.658687"
    val LON: String = "-4.742564"

    private lateinit var adapter: PrendaAdapter
    private lateinit var prendas: java.util.ArrayList<Prenda>
    private lateinit var prendasTotales: java.util.ArrayList<Prenda>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTask().execute()

        setSupportActionBar(toolbar)
        prendas = generarPrendas()
        prendasTotales = generarPrendas()
        adapter = PrendaAdapter(prendas)
        recyclerPrendas.adapter = adapter
        recyclerPrendas.layoutManager = GridLayoutManager(this, 1)
    }

    fun generarPrendas(): ArrayList<Prenda> {
        val data = arrayListOf<Prenda>()
        data.add(
            Prenda(
                "https://www.varelaintimo.com/images/productos/zdcamisetatirantesalgodonegipcioelastizado3200sportblancovarelaintimo01.jpg",
                "Tirantes",
                "25º, 26º, 27º, 28º, 29º, 30º",
                "Blanca",
                "Superior"
            )
        )
        data.add(
            Prenda(
                "https://srv.latostadora.com/designall.dll/camiseta_ls--i:13562320493530135623201709265;b:f8f8f8;s:H_A5;f:f;k:b549543a6f65c85b65ed77d125f2b947;p:1.jpg",
                "Camiseta",
                "18º, 19º, 20º, 21º, 22º, 23º, 24º",
                "Blanca",
                "Superior"
            )
        )
        data.add(
            Prenda(
                "https://images-na.ssl-images-amazon.com/images/I/61dObu7PvCL._UX679_.jpg",
                "Bomber",
                "10º, 11º, 12º, 13º, 14º, 15º, 16º, 17º",
                "Negra",
                "Superior"
            )
        )
        data.add(
            Prenda(
                "https://www.dhresource.com/0x0s/f2-albu-g8-M01-53-73-rBVaV1yW0UCAAUbFAAEYnIEe8so085.jpg/2019-abrigo-nueva-moda-trench-coat-men-plus.jpg",
                "Abrigo",
                "05º, 06º, 07º, 08º, 09º",
                "Veis",
                "Superior"
            )
        )
        data.add(
            Prenda(
                "https://dlse75o8lnzxr.cloudfront.net/media/catalog/product/cache/1/image/1000x/9df78eab33525d08d6e5fb8d27136e95/t/n/tnf-parka-908-1_1.jpg",
                "Abrigo",
                "00º, 01º, 02º, 03º, 04º",
                "Negro",
                "Superior"
            )
        )
        data.add(
            Prenda(
                "https://dossaeformentera.com/wp-content/uploads/2018/01/Ba%C3%B1ador-Hombre-Saona-Azul-Vista-Frontal.jpg",
                "Bañador",
                "25º, 26º, 27º, 28º, 29º, 30º",
                "Azul",
                "Inferior"
            )
        )
        data.add(
            Prenda(
                "https://www.comprarmallas.com/803-large_default/pantalon-corto-hombre-deporte-con-goma-elastica.jpg",
                "Pantalón corto",
                "18º, 19º, 20º, 21º, 22º, 23º, 24º",
                "Rojo",
                "Inferior"
            )
        )
        data.add(
            Prenda(
                "https://cdn.shopify.com/s/files/1/1202/6644/products/BS4996_Hombre_Pantalon_largo_Essentials_Box_Logo_5_800x.jpg?v=1501592318",
                "Pantalón largo",
                "10º, 11º, 12º, 13º, 14º, 15º, 16º, 17º",
                "Azul",
                "Inferior"
            )
        )
        data.add(
            Prenda(
                "https://www.creacionescasbas.com/24406-large_default/pantalon-vaquero-elastico-adrien-confort-41b.jpg",
                "Pantalón vaquero",
                "05º, 06º, 07º, 08º, 09º",
                "Azul oscuro",
                "Inferior"
            )
        )
        data.add(
            Prenda(
                "https://estatico2.spaciobiker.com/170019-large_default/pantalon-vaquero-hombre-by-city-tejano-ii-negro.jpg",
                "Pantalón vaquero",
                "00º, 01º, 02º, 03º, 04º",
                "Negro",
                "Inferior"
            )
        )
        return data
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchView = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        searchView.setOnCloseListener {
            prendas.clear()
            prendas.addAll(prendasTotales)
            adapter.data = prendas
            adapter.notifyDataSetChanged()
            false
        }
        val queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(textoEscrito: String?): Boolean {
                //TODO Cuando se pulsa en el boton de buscar del teclado entra aqui
                if (textoEscrito != null) {
                    prendas = prendasTotales.filter {
                        it.Tiempo.contains(
                            textoEscrito,
                            true
                        )
                    }
                            as ArrayList<Prenda>
                    adapter.data = prendas
                    adapter.notifyDataSetChanged()
                }
                return false
            }

            override fun onQueryTextChange(textoEscrito: String?): Boolean {
                //TODO Cada vez que escribimos una letra entra aqui
                if (textoEscrito != null) {
                    prendas = prendasTotales.filter {
                        it.Tiempo.contains(
                            textoEscrito,
                            true
                        )
                    }
                            as ArrayList<Prenda>
                    adapter.data = prendas
                    adapter.notifyDataSetChanged()
                }
                return false
            }

        }
        searchView.setOnQueryTextListener(queryTextListener)
        return super.onCreateOptionsMenu(menu)
    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }

        /*
                override fun doInBackground(vararg params: String?): String? {
                    var response: String?
                    try {
                        response =
                            URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                                Charsets.UTF_8
                            )
                    } catch (e: Exception) {
                        response = null
                    }
                    return response
                }
         */
        override fun doInBackground(vararg params: String?): String? {
            var response: String?
            try {
                response =
                    URL("https://api.openweathermap.org/data/2.5/weather?lat=$LAT&lon=$LON&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                    )
            } catch (e: Exception) {
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val updatedAt: Long = jsonObj.getLong("dt")
                val updatedAtText =
                    "Actualizado a: " + SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH).format(
                        Date(updatedAt * 1000)
                    )
                val temp = main.getString("temp") + "°C"
                val tempMin = "T. Mín: " + main.getString("temp_min") + "°C"
                val tempMax = "T. Máx: " + main.getString("temp_max") + "°C"
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name") + ", " + sys.getString("country")

                /* Populating extracted data into our views */
                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.updated_at).text = updatedAtText
                findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.temp_min).text = tempMin
                findViewById<TextView>(R.id.temp_max).text = tempMax
                /* Views populated, Hiding the loader, Showing the main design */
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}

