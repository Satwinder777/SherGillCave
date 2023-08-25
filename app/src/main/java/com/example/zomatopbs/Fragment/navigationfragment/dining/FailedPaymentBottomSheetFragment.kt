package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentFailedPaymentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FailedPaymentBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding :FragmentFailedPaymentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFailedPaymentBottomSheetBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.personalcard.setOnClickListener {
            this.dismiss()
            findNavController().navigate(R.id.paymentSuccessFragment)
        }
    }


}