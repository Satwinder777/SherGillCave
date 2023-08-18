package com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentSelectlanguageBSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectlanguageBSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding :FragmentSelectlanguageBSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectlanguageBSheetBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}