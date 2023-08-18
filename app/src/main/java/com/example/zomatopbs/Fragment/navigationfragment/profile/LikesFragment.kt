package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.LikeFavorateFoodAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLikesBinding


class LikesFragment : Fragment() {
    private lateinit var binding : FragmentLikesBinding
    private lateinit var adapter : LikeFavorateFoodAdapter
    private lateinit var rc : RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLikesBinding.inflate(layoutInflater)
        rc = binding.likesRc
        adapter = LikeFavorateFoodAdapter(initData())
        rc.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }


    private fun initData():MutableList<Pair<Int,String>>{

        val list = mutableListOf<Pair<Int,String>>(
            Pair(2,"Pizza fast food "),
            Pair(3,"Onion Pizza "),
            Pair(1,"Paneer Pizza "),
            Pair(5,"corn Pizza "),
            Pair(8,"veg Pizza "),


        )

        return list
    }

}