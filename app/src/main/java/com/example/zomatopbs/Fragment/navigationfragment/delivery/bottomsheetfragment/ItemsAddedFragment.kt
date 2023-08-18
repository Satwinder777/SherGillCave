package com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.databinding.FragmentItemsAddedBinding
import com.example.zomatopbs.objects.MyConstant
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemsAddedFragment(val dl: BottomSheetDialogFragment) : BottomSheetDialogFragment() {

    private lateinit var binding :FragmentItemsAddedBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentItemsAddedBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.itemAdded1.setOnClickListener {
            val dialogFragment = DeliveryAtLocationFragment(this)
            dialogFragment.show(requireFragmentManager(),MyConstant.tag)
            dl.dismiss()
//            dialogFragment.dismiss()

        }
    }

}