package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class OfferItemAdapter(val list: MutableList<OfferModelCls>):RecyclerView.Adapter<OfferItemAdapter.OfferCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.offer_item1,parent,false)
        return OfferCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OfferCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class OfferCls(view: View):RecyclerView.ViewHolder(view) {
        //        val sortxt = view.findViewById<TextView>(R.id.myText)
        val offer_item1 = view.findViewById<ImageView>(R.id.offer_img)
//        val offer_item2 = view.findViewById<ImageView>(R.id.recomm_img2)

        val offer_item_title1 = view.findViewById<TextView>(R.id.offer_title)
//        val offer_item_title2 = view.findViewById<TextView>(R.id.recomm_title2)

        val recomm_offer_txt1 = view.findViewById<TextView>(R.id.offer_text)
//        val recomm_offer_txt2 = view.findViewById<TextView>(R.id.recomm_offer2)

//        val recomm_time1 = view.findViewById<TextView>(R.id.recomm_time1)
//        val recomm_time2 = view.findViewById<TextView>(R.id.recomm_time1)



        fun bind(item:OfferModelCls){

            offer_item1.setImageResource(item.offerImg)
//            offer_item2.setImageResource(item.img2)

            offer_item_title1.text = item.offerTitle
//            offer_item_title2.text = item.recomm_title2

            recomm_offer_txt1.text = item.offerText
//            recomm_offer_txt2.text = item.recomm_offer2

//            recomm_time1.text = item.recomm_text
//            recomm_time2.text = item.recomm_text2

        }

    }


}
data class OfferModelCls(
    val offerImg :Int,
    val offerTitle :String,
    val offerText :String

)