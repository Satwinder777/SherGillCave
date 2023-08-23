package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class CustomerReviewAdapter(val list: MutableList<popularItem1>,val list_review_images : MutableList<Int>):RecyclerView.Adapter<CustomerReviewAdapter.CustomerReviewCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerReviewCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.customer_review_rc_item,parent,false)
        return CustomerReviewCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CustomerReviewCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item,list_review_images)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class CustomerReviewCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.myimage1)
        val offer_item_title1 = view.findViewById<TextView>(R.id.myfoodname)
        val inner_rc = view.findViewById<RecyclerView>(R.id.review_photos_rc)

        fun bind(item:popularItem1,list: MutableList<Int>){

            offer_item1.setImageResource(item.image)
            offer_item_title1.text = item.name
            inner_rc.adapter = ReviewPhotosAdapter(list)


        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }
}



