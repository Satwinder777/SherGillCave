package com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.adapter.CuisinesRcAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentCuisinesBinding


class CuisinesFragment : Fragment() {

    private lateinit var binding : FragmentCuisinesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCuisinesBinding.inflate(layoutInflater)
        val rc = binding.cuisinesRc
        val adapter = CuisinesRcAdapter(initData())
            rc.adapter = adapter
        return binding.root
    }

    private fun initData(): MutableList<String>{
        return mutableListOf("Afgan","American","Arabian",
            "Asian","Assamese","Awadhi","Bakery","Bar Food",
            "BBQ","Belgian","Bengali","Beverages"
            ,"Bihari","Biryani",
            "Bubble Tea","Burger","Cafe","Chinese","Coffee")
    }
}