package com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentCompleteAddressBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CompleteAddressFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentCompleteAddressBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCompleteAddressBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveAddress.setOnClickListener {
            this.dismiss()
            findNavController().navigate(R.id.foodDetailsFragment)
        }


    }


}