package com.example.zomatopbs.Fragment.navigationfragment.grocery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentGroceryBinding


class GroceryFragment : Fragment() {

    private lateinit var binding : FragmentGroceryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentGroceryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.checkLocation.setOnClickListener{
            try {
                findNavController().navigate(R.id.selectLocationFragment)
            }
            catch (e:Exception){
                Log.e("Sattaexp", "onViewCreated: exception is :>>  ${e.message}", )
            }
        }
        binding.profileIcon.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
        binding.languageBtn.setOnClickListener {
//            val bottomSheetFragment = SelectlanguageBSheetFragment()

            findNavController().navigate(R.id.supportMessengerFragment)
//            bottomSheetFragment.show(requireFragmentManager(), bottomSheetFragment.tag)
        }
    }




}