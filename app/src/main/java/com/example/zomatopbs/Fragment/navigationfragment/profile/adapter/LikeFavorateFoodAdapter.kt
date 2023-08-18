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

class LikeFavorateFoodAdapter(val list: MutableList<Pair<Int,String>>):RecyclerView.Adapter<LikeFavorateFoodAdapter.LikesFavorateItemCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikesFavorateItemCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.like_rc_item
            ,parent,false)
        return LikesFavorateItemCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LikesFavorateItemCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class LikesFavorateItemCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item_title1 = view.findViewById<TextView>(R.id.pizzaName)




        fun bind(item: Pair<Int,String>){

//            val final = "${item.first} X ${item.second}"
//            val coloredText = final
//            val spannableString = SpannableString(coloredText)
//
//            val startIndex = coloredText.indexOf("${item.second}")
//            val endIndex = startIndex + item.second.length
//
//            val colorSpan = ForegroundColorSpan(Color.BLACK)
//            spannableString.setSpan(colorSpan, startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
//
//
//            offer_item_title1.text = spannableString
            offer_item_title1.text = item.second


        }

    }


}