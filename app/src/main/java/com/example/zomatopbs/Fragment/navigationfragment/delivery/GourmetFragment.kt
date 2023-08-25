package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.GourmetAdapter
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.popularItem
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentGourmetBinding


class GourmetFragment : Fragment() {
    private lateinit var binding : FragmentGourmetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGourmetBinding.inflate(layoutInflater)

        val rc = binding.popularItemRc
        val adapetr = GourmetAdapter(initData())
        rc.adapter  = adapetr
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }
    fun initData():MutableList<popularItem>{

        return mutableListOf(
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image1, R.drawable.image2, "Special Cake", "Special Chawal",),
            popularItem(R.drawable.image3, R.drawable.image4, "Special Cake", "Special Chawal",),
        )
    }
}