package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class SortingRecyclerAdapter(val list: MutableList<String>):RecyclerView.Adapter<SortingRecyclerAdapter.SortCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.sorting_item_rc,parent,false)
        return SortCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SortCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class SortCls(view: View):RecyclerView.ViewHolder(view) {
        val sortxt = view.findViewById<TextView>(R.id.myText)

        fun bind(text:String){
            sortxt.text = text
        }

    }
}