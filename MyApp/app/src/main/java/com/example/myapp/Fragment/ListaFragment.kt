package com.example.myapp.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.example.myapp.R
import com.example.myapp.wallapop.Producto
import com.example.myapp.wallapop.ProductosAdapter
import kotlinx.android.synthetic.main.activity_wallapop.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class ListaFragment : Fragment() {


    private lateinit var productos: ArrayList<Producto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productos = generarProductos()
        recyclerProductos.layoutManager = GridLayoutManager(context, 2)
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
