package com.example.myapp.wallapop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapp.R
import kotlinx.android.synthetic.main.activity_wallapop.*

class WallapopActivity : AppCompatActivity() {

    private lateinit var productos: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallapop)

        productos = generarProductos()
        recyclerProductos.layoutManager = GridLayoutManager(this, 2)
        recyclerProductos.adapter = ProductosAdapter(productos)
    }

    private fun generarProductos(): ArrayList<Producto> {
        val productos = arrayListOf<Producto>()
        productos.add(
            Producto(
                "https://dulcemisu.com/blog/wp-content/uploads/2017/11/Tarta-reno-de-chocolate-1-3.jpg",
                30.0f,
                "Reno de chocolate suizo del 80%",
                "Reno de chocolate",
                false
            )
        )
        productos.add(
            Producto(
                "https://images-na.ssl-images-amazon.com/images/I/61sW3hVUXXL._SL1050_.jpg",
                250.0f,
                "Movil Motorola con 3GB de RAM",
                "Moto G6",
                true
            )
        )
        return productos
    }
}
