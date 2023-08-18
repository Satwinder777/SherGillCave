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

class YourTransactionsAdapter(val list: MutableList<String>):RecyclerView.Adapter<YourTransactionsAdapter.YourTransactionsCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourTransactionsCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.your_transaction_item_rc,parent,false)
        return YourTransactionsCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: YourTransactionsCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class YourTransactionsCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item_title1 = view.findViewById<TextView>(R.id.pizzaNameYourTransactions)


        fun bind(item: String){
//            val final = "${item.first} X ${item.second}"
//
//            val coloredText = final
//            val spannableString = SpannableString(coloredText)
//
//            val startIndex = coloredText.indexOf("${item.second}")
//            val endIndex = startIndex + item.second.length
//
//            val colorSpan = ForegroundColorSpan(Color.BLACK)
//            spannableString.setSpan(colorSpan, startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

//            textView.text =
            offer_item_title1.text = item


        }

    }


}