package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class DiningRecommRcAdapter(val list: MutableList<DiningRecommodel>):RecyclerView.Adapter<DiningRecommRcAdapter.DiningRecommCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiningRecommCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.recommedation_rc_item,parent,false)
        return DiningRecommCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DiningRecommCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class DiningRecommCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.recoImg)
        val offer_item_title1 = view.findViewById<TextView>(R.id.recotitle)
        val offer_item_title2 = view.findViewById<TextView>(R.id.recoText)






        fun bind(item:DiningRecommodel){

            offer_item1.setImageResource(item.img)
            offer_item_title1.text = item.title
            offer_item_title2.text = item.text

        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }


}

data class DiningRecommodel(
    val img : Int,
    val title : String,
    val text : String,
    )