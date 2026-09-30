package com.cscorner.kotline_first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdepterClass(private  var items: MutableList<items_Data>):
        RecyclerView.Adapter<AdepterClass.ViewHolder>()
{

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.text)
        val description: TextView = itemView.findViewById(R.id.text2)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemrecyca_view, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val items = items[position]
        holder.title.text = items.title
        holder.description.text = items.description
    }

    override fun getItemCount()=items.size
}