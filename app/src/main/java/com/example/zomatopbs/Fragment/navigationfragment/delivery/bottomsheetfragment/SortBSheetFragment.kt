package com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentRatingBinding
import com.example.zomatopbs.databinding.FragmentSortBSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SortBSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSortBSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSortBSheetBinding.inflate(layoutInflater)
        return binding.root
    }

}