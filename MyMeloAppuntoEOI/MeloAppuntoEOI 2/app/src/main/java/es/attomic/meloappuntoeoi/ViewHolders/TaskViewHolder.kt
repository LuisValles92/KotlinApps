package es.attomic.meloappuntoeoi.ViewHolders

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import es.attomic.meloappuntoeoi.Models.Task
import es.attomic.meloappuntoeoi.R

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  val nombreTarea = itemView.findViewById<TextView>(R.id.textTask)
  val categoria = itemView.findViewById<TextView>(R.id.txtCategory)
  val delete = itemView.findViewById<ImageButton>(R.id.closeButton)
  val check = itemView.findViewById<CheckBox>(R.id.checkboxTask)
  val cardView = itemView.findViewById<CardView>(R.id.carditem)

  fun bindTask(item: Task) {
    nombreTarea.text = item.text
    categoria.text = item.category
  }

}


