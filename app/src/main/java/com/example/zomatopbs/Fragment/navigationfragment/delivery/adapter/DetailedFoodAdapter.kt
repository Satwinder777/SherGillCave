package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class DetailedFoodAdapter(val list: MutableList<foodmodelcls>,val onclick :onPreviewClick):RecyclerView.Adapter<DetailedFoodAdapter.DetailedFoodCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedFoodCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.recommended_receipe,parent,false)
        return DetailedFoodCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailedFoodCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)

            itemView.setOnClickListener {
                onclick.additem()
            }
        }

    }
    class DetailedFoodCls(view: View):RecyclerView.ViewHolder(view) {

        val offer_item1 = view.findViewById<TextView>(R.id.foodtype)





        fun bind(item:foodmodelcls){

            offer_item1.text = item.foodname


        }

    }

interface onPreviewClick{
    fun additem()
}
}
data class foodmodelcls(
    val foodname:String
)