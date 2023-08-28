package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLogOutBinding
import com.example.zomatopbs.sharephref.SharedPreferencesHelper


class LogOutFragment : DialogFragment() {

    private lateinit var binding : FragmentLogOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLogOutBinding.inflate(layoutInflater)

        val cornerRadius = resources.getDimensionPixelSize(R.dimen.dialog_corner_radius) // You can define this in your dimens.xml
        val shapeDrawable = GradientDrawable()
        shapeDrawable.shape = GradientDrawable.RECTANGLE
        shapeDrawable.setColor(Color.WHITE)
        shapeDrawable.cornerRadius = cornerRadius.toFloat()
        this.dialog?.window?.setBackgroundDrawable(shapeDrawable)
       this.isCancelable = false


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelButton.setOnClickListener {
            this.dismiss()
        }
        binding.currentDevice.setOnClickListener {
            this.dismiss()
            SharedPreferencesHelper(requireContext()).clearAllData()
            findNavController().navigateUp()
            findNavController().popBackStack()
        }
        binding.allDevices.setOnClickListener {
            this.dismiss()
            SharedPreferencesHelper(requireContext()).clearAllData()
            val fragmentToRemove = requireActivity().finish()

        }

    }


}