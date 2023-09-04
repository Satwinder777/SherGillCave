package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.zomatopbs.Interfaces.apimodel.PizzaListResponce
import com.example.zomatopbs.R

class RecommendedItemAdapter(var list: PizzaListResponce?, val onclick :onRecommendedItemClick):RecyclerView.Adapter<RecommendedItemAdapter.RecommednedCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommednedCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.recommended_item,parent,false)
        return RecommednedCls(myView)
    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    override fun onBindViewHolder(holder: RecommednedCls, position: Int) {
        val item = list
        holder.apply {
            if (item != null) {
                bind(item)
            }
            itemView.setOnClickListener {
                onclick.onRecommItemClick()
            }
        }

    }
    class RecommednedCls(view: View):RecyclerView.ViewHolder(view) {
//        val sortxt = view.findViewById<TextView>(R.id.myText)
        val recomm_img1 = view.findViewById<ImageView>(R.id.recomm_img1)
//        val recomm_img2 = view.findViewById<ImageView>(R.id.recomm_img2)

        val recomm_title1 = view.findViewById<TextView>(R.id.recomm_title1)
//        val recomm_title2 = view.findViewById<TextView>(R.id.recomm_title2)

        val recomm_offer1 = view.findViewById<TextView>(R.id.recomm_offer1)
//        val recomm_offer2 = view.findViewById<TextView>(R.id.recomm_offer2)

        val recomm_time1 = view.findViewById<TextView>(R.id.recomm_time1)
//        val recomm_time2 = view.findViewById<TextView>(R.id.recomm_time1)



        fun bind(item:PizzaListResponce){

            var m_item = item[position]
//            recomm_img1.setImageResource(item.img1)
////            recomm_img2.setImageResource(item.img2)
//
//            recomm_title1.text = item.recomm_title
////            recomm_title2.text = item.recomm_title2
//
//            recomm_offer1.text = item.recomm_offer1
////            recomm_offer2.text = item.recomm_offer2
//
//            recomm_time1.text = item.recomm_text
//            recomm_time2.text = item.recomm_text2
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.pizza1) // Placeholder image while loading (optional)
                .error(R.drawable.error_icon)
//            recomm_img2.setImageResource(item.img2)

            Glide.with(itemView.context)
                .load(m_item.img)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade()) // Crossfade animation (optional)
                .into(recomm_img1)

            recomm_title1.text = m_item.name
//            recomm_title2.text = item.recomm_title2

            recomm_offer1.text = m_item.description
//            recomm_offer2.text = item.recomm_offer2

//            recomm_time1.text = m_item.price.toString()
//            recomm_time2.text = item.recomm_text2

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

