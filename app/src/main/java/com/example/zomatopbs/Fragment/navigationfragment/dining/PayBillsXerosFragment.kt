package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentPayBillsXerosBinding


class PayBillsXerosFragment : Fragment() {

    private lateinit var binding :FragmentPayBillsXerosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPayBillsXerosBinding.inflate(layoutInflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onback.setOnClickListener {
            requireActivity().onBackPressed()
        }
        try {
            binding.Button.setOnClickListener {
                findNavController().navigate(R.id.billDetailsXeroFragment)
            }
//            val btn  = requireView().findViewById<Button>(R.id.Button)
//          btn.setOnClickListener {
//            }
        }
        catch (e:Exception){
            Log.e("satta21", "onViewCreated: ${e.message}", )
        }
    }

}