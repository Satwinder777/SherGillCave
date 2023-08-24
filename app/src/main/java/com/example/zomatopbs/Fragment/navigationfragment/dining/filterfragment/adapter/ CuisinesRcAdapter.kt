package com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.adapter




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.R

class CuisinesRcAdapter(val list: MutableList<String>):RecyclerView.Adapter<CuisinesRcAdapter.CuisinesCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuisinesCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.check_rc_item,parent,false)
        return CuisinesCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CuisinesCls, position: Int) {
        val item = list.get(position)
        holder.apply {
            bind(item)
//            itemView.setOnClickListener {
//                onclick?.onclickofferitem(position)
//            }
        }

    }
    class CuisinesCls(view: View):RecyclerView.ViewHolder(view) {

//        val offer_item1 = view.findViewById<ImageView>(R.id.lookingImage)
        val offer_item_title1 = view.findViewById<CheckBox>(R.id.myCheckBox1)






        fun bind(item:String){

//            offer_item1.setImageResource(item)
            offer_item_title1.setText(item)

        }

    }


}

