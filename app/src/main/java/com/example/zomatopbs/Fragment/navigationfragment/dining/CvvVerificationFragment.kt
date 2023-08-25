package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentCvvVerificationBinding
import com.example.zomatopbs.objects.MyConstant


class CvvVerificationFragment : Fragment() {

    private lateinit var binding : FragmentCvvVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCvvVerificationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.submit.setOnClickListener {
            val dialog = FailedPaymentBottomSheetFragment()
            dialog.show(requireActivity().supportFragmentManager,MyConstant.tag)
        }


    }

}