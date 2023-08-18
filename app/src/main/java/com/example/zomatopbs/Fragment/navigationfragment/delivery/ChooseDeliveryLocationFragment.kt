package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.CompleteAddressFragment
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentChooseDeliveryLocationBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant


class ChooseDeliveryLocationFragment : Fragment() {
    private lateinit var binding:FragmentChooseDeliveryLocationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChooseDeliveryLocationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitAddress.setOnClickListener {
            try {
//                findNavController().navigateUp()
//                findNavController().navigate(R.id.completeAddressFragment)

                CompleteAddressFragment().show(requireFragmentManager(),MyConstant.tag)
            }
            catch (e:Exception){
                Log.e("satta", "onViewCreated: exp>>${e.message}", )
            }
//            Allfun.navigateScr(DeliveryFragment(),requireFragmentManager())
        }
    }

}