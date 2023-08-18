package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentFeedingIndiaBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FeedingIndiaFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentFeedingIndiaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedingIndiaBinding.inflate(layoutInflater)

//        val cornerRadius = resources.getDimensionPixelSize(R.dimen.dialog_corner_radius) // You can define this in your dimens.xml
//        val shapeDrawable = GradientDrawable()
//        shapeDrawable.shape = GradientDrawable.RECTANGLE
//        shapeDrawable.setColor(Color.WHITE)
//        shapeDrawable.cornerRadius = cornerRadius.toFloat()
//
//        dialog?.window?.setBackgroundDrawable(shapeDrawable)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}