package com.example.myapp.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(
    var data: ArrayList<Album>,
    var onAlbumClick: (album: Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Album) {
            itemView.tvName.text = item.nombre
            itemView.tvYearsSongs.text = "${item.anio} - ${item.canciones}"
            if (!item.imagen.isNullOrEmpty()) {
                Picasso.get().load(item.imagen).into(itemView.ivAlbum)
            }
            itemView.setOnClickListener{
                onAlbumClick(item)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }

}