package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class RecommendedItemAdapter(val list: MutableList<recommendItemData>,val onclick :onRecommendedItemClick):RecyclerView.Adapter<RecommendedItemAdapter.RecommednedCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommednedCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.recommended_item,parent,false)
        return RecommednedCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecommednedCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
            itemView.setOnClickListener {
                onclick.onRecommItemClick()
            }
        }

    }
    class RecommednedCls(view: View):RecyclerView.ViewHolder(view) {
//        val sortxt = view.findViewById<TextView>(R.id.myText)
        val recomm_img1 = view.findViewById<ImageView>(R.id.recomm_img1)
        val recomm_img2 = view.findViewById<ImageView>(R.id.recomm_img2)

        val recomm_title1 = view.findViewById<TextView>(R.id.recomm_title1)
        val recomm_title2 = view.findViewById<TextView>(R.id.recomm_title2)

        val recomm_offer1 = view.findViewById<TextView>(R.id.recomm_offer1)
        val recomm_offer2 = view.findViewById<TextView>(R.id.recomm_offer2)

        val recomm_time1 = view.findViewById<TextView>(R.id.recomm_time1)
        val recomm_time2 = view.findViewById<TextView>(R.id.recomm_time1)



        fun bind(item:recommendItemData){

            recomm_img1.setImageResource(item.img1)
            recomm_img2.setImageResource(item.img2)

            recomm_title1.text = item.recomm_title
            recomm_title2.text = item.recomm_title2

            recomm_offer1.text = item.recomm_offer1
            recomm_offer2.text = item.recomm_offer2

            recomm_time1.text = item.recomm_text
            recomm_time2.text = item.recomm_text2

        }

    }
    interface onRecommendedItemClick{
       fun onRecommItemClick()
    }
}
data class recommendItemData(
    val img1 :Int,
    val img2 :Int,
    val recomm_title :String,
    val recomm_title2 :String,
    val recomm_text:String,
    val recomm_text2:String,
    val recomm_offer1:String,
    val recomm_offer2:String,
)