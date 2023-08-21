package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class GourmetAdapter(val list: MutableList<popularItem>):RecyclerView.Adapter<GourmetAdapter.GaoumetCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaoumetCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.popular_breakfast_item_rc,parent,false)
        return GaoumetCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GaoumetCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class GaoumetCls(view: View):RecyclerView.ViewHolder(view) {
        //        val sortxt = view.findViewById<TextView>(R.id.myText)
        val offer_item1 = view.findViewById<ImageView>(R.id.popular_image1)
        val offer_item2 = view.findViewById<ImageView>(R.id.popular_image2)
//        val offer_item2 = view.findViewById<ImageView>(R.id.recomm_img2)

        val offer_item_title1 = view.findViewById<TextView>(R.id.popular_text1)
//        val offer_item_title2 = view.findViewById<TextView>(R.id.recomm_title2)

        val recomm_offer_txt1 = view.findViewById<TextView>(R.id.popular_text2)
//        val recomm_offer_txt2 = view.findViewById<TextView>(R.id.recomm_offer2)

//        val recomm_time1 = view.findViewById<TextView>(R.id.recomm_time1)
//        val recomm_time2 = view.findViewById<TextView>(R.id.recomm_time1)



        fun bind(item:popularItem){

            item.image1?.let { offer_item1.setImageResource(it) }
            item.image2?.let { offer_item2.setImageResource(it) }
//            offer_item2.setImageResource(item.img2)

            offer_item_title1.text = item.text1
//            offer_item_title2.text = item.recomm_title2

            recomm_offer_txt1.text = item.text2
//            recomm_offer_txt2.text = item.recomm_offer2

//            recomm_time1.text = item.recomm_text
//            recomm_time2.text = item.recomm_text2

        }

    }

    interface OnOfferItemClick{
        fun onclickofferitem(position: Int)
    }
}
data class popularItem(
    val image1:Int?,
    val image2:Int?,
    val text1:String?,
    val text2:String?,

)
