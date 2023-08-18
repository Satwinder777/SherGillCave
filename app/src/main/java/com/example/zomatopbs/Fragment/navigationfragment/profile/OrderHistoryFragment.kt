package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.OrderHistoryAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentOrderHistoryBinding


class OrderHistoryFragment : Fragment() {
    private lateinit var binding : FragmentOrderHistoryBinding
    private lateinit var adapter : OrderHistoryAdapter
    private lateinit var rc : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderHistoryBinding.inflate(layoutInflater)
        rc = binding.orderHistoryRc
        adapter = OrderHistoryAdapter(initData())
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
            Pair(2,"Onion pizza "),Pair(1,"Paneer Pizza"),Pair(1,"delicious Pizza"),Pair(3,"myfavorate pizza "),Pair(5,"mom magic pizza "))
        return list
    }
}