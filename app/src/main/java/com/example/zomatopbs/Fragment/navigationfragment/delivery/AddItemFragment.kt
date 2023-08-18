package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.ItemsAddedFragment
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentAddItemBinding
import com.example.zomatopbs.objects.MyConstant
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddItemFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentAddItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pizzademo.setOnClickListener {
            val dialog = ItemsAddedFragment(this)

           dialog.show(requireFragmentManager(),MyConstant.tag)
            Log.e(MyConstant.tag, "onViewCreated: clicked", )
        }
    }

}