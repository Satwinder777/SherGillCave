package com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.zomatopbs.R

class SavedAdressAdapter(val list: MutableList<savedAddressData>):RecyclerView.Adapter<SavedAdressAdapter.SavedAdressCls>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedAdressCls {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.saved_list_item,parent,false)
        return SavedAdressCls(myView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SavedAdressCls, position: Int) {
        val item = list[position]
        holder.apply {
            bind(item)
        }

    }
    class SavedAdressCls(view: View):RecyclerView.ViewHolder(view) {

        val add_distance = view.findViewById<TextView>(R.id.add_distance)

        val add_title = view.findViewById<TextView>(R.id.add_title)
        val add_text = view.findViewById<TextView>(R.id.add_text)



        fun bind(item:savedAddressData){

            add_distance.text = item.distance
            add_title.text = item.add_title
            add_text.text = item.add_text

        }

    }
}

data class savedAddressData(
    val distance:String,
    val add_title:String,
    val add_text:String,
)