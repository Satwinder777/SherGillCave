package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class PhotosRcAdapter(val list: MutableList<photosRcmodel>):RecyclerView.Adapter<PhotosRcAdapter.PhotosRcCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosRcCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.photots_rc_item,parent,false)
        return PhotosRcCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PhotosRcCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class PhotosRcCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<ImageView>(R.id.photoimg)
        val offer_item_title1 = view.findViewById<TextView>(R.id.photostittletext)
        val offer_item_title2 = view.findViewById<TextView>(R.id.photorelatedtext)






        fun bind(item:photosRcmodel){

            offer_item1.setImageResource(item.img)
            offer_item_title1.text = item.title
            offer_item_title2.text = item.text

        }

    }

//    interface OnOfferItemClick{
//        fun onclickofferitem(position: Int)
//    }


}

data class photosRcmodel(
    val img : Int,
    val title : String,
    val text : String,
    )