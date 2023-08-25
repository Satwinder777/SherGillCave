package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.GoldOfferRcAdapterAdapter
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.GoldOfferRcModel
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentGoldOfferBinding

class GoldOfferFragment : Fragment() {
    private lateinit var binding: FragmentGoldOfferBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGoldOfferBinding.inflate(layoutInflater)
        val rc = binding.goldRc
        val adapter = GoldOfferRcAdapterAdapter(initData())
        rc.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    private fun initData():MutableList<GoldOfferRcModel>{
       return mutableListOf<GoldOfferRcModel>(
            GoldOfferRcModel(R.drawable.pizza1,"Pizza Paneer" ),
            GoldOfferRcModel(R.drawable.pizza2,"Onion Paneer"),
            GoldOfferRcModel(R.drawable.image1,"Chocklate Cake"),
            GoldOfferRcModel(R.drawable.image2,"Fried Chawal"),
            GoldOfferRcModel(R.drawable.image3,"South Plate"),
            GoldOfferRcModel(R.drawable.image4,"Delicious Food"),
            GoldOfferRcModel(R.drawable.pizza1,"Pizza Paneer"),

        )
    }
}