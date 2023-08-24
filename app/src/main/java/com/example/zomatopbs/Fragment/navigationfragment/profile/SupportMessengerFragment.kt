package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.SupportMassengerAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentSupportMessengerBinding

class SupportMessengerFragment : Fragment() {
    private lateinit var binding: FragmentSupportMessengerBinding
    private lateinit var adapter: SupportMassengerAdapter
    private lateinit var rc: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSupportMessengerBinding.inflate(layoutInflater)
        adapter = SupportMassengerAdapter(initData())
        rc = binding.supportRc
        rc.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun initData():MutableList<String>{

        return mutableListOf(" Hi Satwinder this side \nPossibility Support","this is a confirmation massge \n your Otp is 1907962 ","please Go to www.Satwinder_shergill.com  and login")
    }
}