package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class OfferItem60(val list: MutableList<OfferModelCls>, val onclick: OnOfferItemClick?):RecyclerView.Adapter<OfferItem60.OfferCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.off_deal_item_rc_60,parent,false)
        return OfferCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OfferCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                onclick?.onclickofferitem(position)
            }
        }

    }
    class OfferCls(view: View):RecyclerView.ViewHolder(view) {
        //        val sortxt = view.findViewById<TextView>(R.id.myText)
        val offer_item1 = view.findViewById<ImageView>(R.id.imageoffer)
//        val offer_item2 = view.findViewById<ImageView>(R.id.recomm_img2)

        val offer_item_title1 = view.findViewById<TextView>(R.id.textoffer1)
//        val offer_item_title2 = view.findViewById<TextView>(R.id.recomm_title2)

        val recomm_offer_txt1 = view.findViewById<TextView>(R.id.textoffer2)
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

    interface OnOfferItemClick{
        fun onclickofferitem(position: Int)
    }
}
