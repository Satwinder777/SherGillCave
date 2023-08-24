package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentPaymentMethodBinding

class PaymentMethodFragment : Fragment() {
    private lateinit var binding :FragmentPaymentMethodBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentMethodBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.recomendedcard.setOnClickListener {
           findNavController().navigate(R.id.cvvVerificationFragment)
        }
    }

}