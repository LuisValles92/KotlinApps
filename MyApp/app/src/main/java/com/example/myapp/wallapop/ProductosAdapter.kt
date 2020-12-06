package com.example.myapp.wallapop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.album.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*
import kotlinx.android.synthetic.main.item_wallapop.view.*

class ProductosAdapter(private val productos: ArrayList<Producto>) :
    RecyclerView.Adapter<ProductosAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun mostrar(item:Producto) {
            itemView.tvPrecio.text=item.precio.toString()
            itemView.tvTitulo.text=item.titulo
            if (!item.fotoUrl.isNullOrEmpty()) {
                Picasso.get().load(item.fotoUrl).into(itemView.ivProducto)
            }

            if(item.esFavorito){
                itemView.ivFavorito.setColorFilter(itemView.context.getColor(R.color.colorAccent))
            }
            else{
                itemView.ivFavorito.setImageResource(R.drawable.ic_favorite_border_24px)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductosAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wallapop, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mostrar(productos[position])
    }

    override fun getItemCount()=productos.size
}