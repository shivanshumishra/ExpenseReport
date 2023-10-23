package com.example.expensereport.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.expensereport.R

class GridListAdapter(private val listItems : ArrayList<String>,val onItemClick : (String) -> Unit) : RecyclerView.Adapter<GridListAdapter.AdapterViewHolder>() {

    class AdapterViewHolder(view: View) : ViewHolder(view){
        val itemTextView: TextView = view.findViewById(R.id.itemText)
        val itemCardView: CardView = view.findViewById(R.id.itemCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_layout,parent,false)
        return AdapterViewHolder(view)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemTextView.text = listItems[position]
        holder.itemCardView.setOnClickListener {
            onItemClick(holder.itemTextView.text as String)
        }
    }
}