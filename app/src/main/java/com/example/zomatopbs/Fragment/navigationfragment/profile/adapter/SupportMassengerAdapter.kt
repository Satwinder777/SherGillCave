package com.example.zomatopbs.Fragment.navigationfragment.profile.adapter






import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class SupportMassengerAdapter(val list: MutableList<String>):RecyclerView.Adapter<SupportMassengerAdapter.SupportMassengerCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupportMassengerCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.item_massage_support_rc
            ,parent,false)
        return SupportMassengerCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SupportMassengerCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class SupportMassengerCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item_title1 = view.findViewById<TextView>(R.id.myTextMessage)




        fun bind(item: String){

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
            offer_item_title1.text = item


        }

    }


}