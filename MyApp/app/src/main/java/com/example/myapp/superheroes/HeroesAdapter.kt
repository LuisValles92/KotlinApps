package com.example.myapp.superheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.superheroes.modelo.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superheroes.view.*

class HeroesAdapter(private val heroes: List<Result>) :
    RecyclerView.Adapter<HeroesAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun mostrar(item: Result) {
            itemView.heroeNombre.text = item.name.toUpperCase()
            if (item.image.url.isNotEmpty()) {
                Picasso.get().load(item.image.url).into(itemView.heroeImagen)
            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeroesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superheroes, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mostrar(heroes[position])
    }

    override fun getItemCount() = heroes.size
}