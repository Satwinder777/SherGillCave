package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class GoldOfferRcAdapterAdapter(val list: MutableList<GoldOfferRcModel>):RecyclerView.Adapter<GoldOfferRcAdapterAdapter.GoldOfferRcCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldOfferRcCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.gold_offer_rc_item,parent,false)
        return GoldOfferRcCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GoldOfferRcCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class GoldOfferRcCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.offerDishImage)
        val offer_item_title1 = view.findViewById<TextView>(R.id.offerDishName)






        fun bind(item:GoldOfferRcModel){

            offer_item1.setImageResource(item.img)
            offer_item_title1.text = item.name

        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }
}
data class GoldOfferRcModel(
    val img : Int,
    val name : String,
)

