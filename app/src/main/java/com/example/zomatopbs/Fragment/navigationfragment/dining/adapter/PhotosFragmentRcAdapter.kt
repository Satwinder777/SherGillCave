package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class PhotosFragmentRcAdapter(val list: MutableList<Int>):RecyclerView.Adapter<PhotosFragmentRcAdapter.PhotosFragmentRcCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosFragmentRcCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.custom_my_card2,parent,false)
        return PhotosFragmentRcCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PhotosFragmentRcCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class PhotosFragmentRcCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.customCardSecond)
//        val offer_item_title1 = view.findViewById<TextView>(R.id.lookingText)






        fun bind(item:Int){

            offer_item1.setImageResource(item)
//            offer_item_title1.text = item.name

        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }
}

