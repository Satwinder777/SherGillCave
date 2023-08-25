package com.example.zomatopbs.Fragment.navigationfragment.money

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentActivateWalletBinding

class ActivateWalletFragment : Fragment() {

    private lateinit var binding : FragmentActivateWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentActivateWalletBinding.inflate(layoutInflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onback.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.onTandc.setOnClickListener {  }
        binding.oncontinue.setOnClickListener {
            requireActivity().onBackPressed()

        }
    }

}