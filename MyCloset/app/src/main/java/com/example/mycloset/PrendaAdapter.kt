package com.example.mycloset

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_prenda.view.*
import com.example.mycloset.R

class PrendaAdapter(
    var data: ArrayList<Prenda>
) : RecyclerView.Adapter<PrendaAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Prenda) {
            if (!item.urlFoto.isNullOrEmpty()) {
                Picasso.get().load(item.urlFoto).into(itemView.prendaFoto)
            }
            itemView.prendaNombre.text = item.Nombre
            itemView.prendaTiempo.text = item.Tiempo
            itemView.prendaColor.text = item.Color
            itemView.prendaCampo.text = item.Campo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_prenda, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}