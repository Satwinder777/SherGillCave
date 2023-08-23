package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.PhotosFragmentRcAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentPhotosBinding


class PhotosFragment : Fragment() {

    private lateinit var binding :FragmentPhotosBinding
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//           param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotosBinding.inflate(layoutInflater)
        val rc = binding.PhotoRc
        val adapter = PhotosFragmentRcAdapter(initData())
        rc.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goback.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    private fun initData():MutableList<Int>{
        return mutableListOf(
            R.drawable.photos1_,
            R.drawable.photos2_,
            R.drawable.photos3_,
            R.drawable.photos4_,
            R.drawable.photos5_,
            R.drawable.photos6_,
            R.drawable.photos7_,
            R.drawable.photos8_,
            R.drawable.photos9_,
            R.drawable.photos10_,
            R.drawable.photos1_,
            R.drawable.photos2_,
            R.drawable.photos3_,
            R.drawable.photos4_,
            R.drawable.photos5_,
            R.drawable.photos6_,
            R.drawable.photos7_,
            R.drawable.photos8_,

        )
    }

}