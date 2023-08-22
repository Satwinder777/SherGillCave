package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class LookingForAdapter(val list: MutableList<popularItem1>):RecyclerView.Adapter<LookingForAdapter.LookingCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LookingCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.looking_rc_item,parent,false)
        return LookingCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LookingCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class LookingCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.lookingImage)
        val offer_item_title1 = view.findViewById<TextView>(R.id.lookingText)






        fun bind(item:popularItem1){

            offer_item1.setImageResource(item.image)
            offer_item_title1.text = item.name

        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }
}

