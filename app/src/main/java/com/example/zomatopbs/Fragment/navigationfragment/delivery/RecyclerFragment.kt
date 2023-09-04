package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.DataClasses.searchitemType
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.recommendItemData
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment() {
    lateinit var binding : FragmentRecyclerBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(layoutInflater)
        val rc = binding.rcMyRC
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    inner class SearchViewFrAdapter(var list: MutableList<searchitemType>):RecyclerView.Adapter<SearchViewFrAdapter.SearchViewCls>(){




        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewCls {
            var view = layoutInflater.inflate(R.layout.recycler_item_rc,parent,false)
           return SearchViewCls(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: SearchViewCls, position: Int) {

        }
        inner class SearchViewCls(view :View):RecyclerView.ViewHolder(view) {

            var img = view.findViewById<ImageView>(R.id.recomm_img1)
            var title = view.findViewById<TextView>(R.id.recomm_title1)
            var desc = view.findViewById<TextView>(R.id.recomm_offer1)



        }
    }
}