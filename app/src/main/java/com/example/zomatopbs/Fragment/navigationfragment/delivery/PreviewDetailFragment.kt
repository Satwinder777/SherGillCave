package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.DetailedFoodAdapter
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.foodmodelcls
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.MenuFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.MoreOptionsFragment
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityMainBinding
import com.example.zomatopbs.databinding.FragmentPreviewDetailBinding
import com.example.zomatopbs.objects.MyConstant


class PreviewDetailFragment : Fragment() , DetailedFoodAdapter.onPreviewClick {
    private lateinit var binding: FragmentPreviewDetailBinding
    private lateinit var adapter : DetailedFoodAdapter
    private lateinit var rc : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPreviewDetailBinding.inflate(layoutInflater)

        rc = binding.detailedItemRc
        adapter = DetailedFoodAdapter(initData(),this)
        rc.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.menuButton.setOnClickListener {
//            requireActivity().onBackPressed()
            MenuFragment().show(requireFragmentManager(),MyConstant.tag)
        }
        binding.moreOption.setOnClickListener {
//            requireActivity().onBackPressed()
            MoreOptionsFragment().show(requireFragmentManager(),MyConstant.tag)
        }
    }
    private fun initData():MutableList<foodmodelcls>{
        val list = mutableListOf<foodmodelcls>(
            foodmodelcls("jalebi"),
            foodmodelcls("pakode"),
            foodmodelcls("rass malayi"),
            foodmodelcls("popkon"),
            foodmodelcls("burger"),
        )
        return list
    }

    override fun additem() {
        AddItemFragment().show(requireFragmentManager(),MyConstant.tag)
    }
}