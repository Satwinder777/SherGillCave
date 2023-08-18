package com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentDeliveryAtLocationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DeliveryAtLocationFragment(val dl: BottomSheetDialogFragment) : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentDeliveryAtLocationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeliveryAtLocationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextpage.setOnClickListener {
            findNavController().navigate(R.id.selectLocationFragment)
            dl.dismiss()
            this.dismiss()

        }

    }

}