package com.example.zomatopbs.Fragment.navigationfragment.profile.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.OfferModelCls


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class AskQuestionEventAdapter(val list: MutableList<String>):RecyclerView.Adapter<AskQuestionEventAdapter.OrderHistoryCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.asked_ques_event_item_rc,parent,false)
        return OrderHistoryCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OrderHistoryCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class OrderHistoryCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item_title1 = view.findViewById<TextView>(R.id.textask)


        fun bind(item: String){

            offer_item_title1.text = item


        }

    }


}