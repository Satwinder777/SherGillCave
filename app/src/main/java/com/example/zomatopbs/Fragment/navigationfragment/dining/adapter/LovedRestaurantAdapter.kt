package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class LovedRestaurantAdapter(val list: MutableList<popularItem1>,val onclick :OnLovedItemClick):RecyclerView.Adapter<LovedRestaurantAdapter.LoveRestaurantsCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveRestaurantsCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.off_deal_item_rc_60,parent,false)
        return LoveRestaurantsCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LoveRestaurantsCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                onclick.onclickloveditem(position)
            }
        }

    }
    class LoveRestaurantsCls(view: View):RecyclerView.ViewHolder(view) {
        val offer_item1 = view.findViewById<ImageView>(R.id.imageoffer)
        val offer_item_title1 = view.findViewById<TextView>(R.id.textoffer1)


        fun bind(item:popularItem1){

            offer_item1.setImageResource(item.image)
            offer_item_title1.text = item.name

        }

    }

    interface OnLovedItemClick{
        fun onclickloveditem(position: Int)
    }
}
data class popularItem1(
    val image : Int,
    val name : String,
)
