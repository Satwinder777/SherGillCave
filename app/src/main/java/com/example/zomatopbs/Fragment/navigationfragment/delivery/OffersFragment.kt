package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.OfferItem60
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.OfferModelCls
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentOffersBinding


class OffersFragment : Fragment() {

    private lateinit var binding: FragmentOffersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOffersBinding.inflate(layoutInflater)
        val rc = binding.recyclerViewOfrer60
        val adapter = OfferItem60(initData(),null)
        rc.adapter = adapter
//        sliderImageSet()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sliderImageSet()
        binding.onback.setOnClickListener {
            requireActivity().onBackPressed()
        }
//        val imageList = ArrayList<SlideModel>() // Create image list
//
//// imageList.add(SlideModel("String Url" or R.drawable)
//// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
//
//        imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
//        imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
//        imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))
//
//        val imageSlider = binding.imageSlider
//
//        imageSlider.setImageList(imageList)
    }
    private fun initData():MutableList<OfferModelCls>{
        var list = mutableListOf<OfferModelCls>(
            OfferModelCls(R.drawable.offer1,"Taco Bell","40% OFF up to ..."),
            OfferModelCls(R.drawable.offer2,"Amingo’s Cafe","40% OFF up to ..."),
            OfferModelCls(R.drawable.offer3,"Garam Dharam","40% OFF up to ..."),
            OfferModelCls(R.drawable.offer1,"Taco Bell","40% OFF up to ..."),
            OfferModelCls(R.drawable.offer2,"Amingo’s Cafe","40% OFF up to ..."),
            OfferModelCls(R.drawable.offer3,"Garam Dharam","40% OFF up to ..."),
        )
        return list
    }
    private fun sliderImageSet() {
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://media.istockphoto.com/id/1442417585/photo/person-getting-a-piece-of-cheesy-pepperoni-pizza.webp?b=1&s=170667a&w=0&k=20&c=27qSFEznalRWqZ5iAgm4fnM6u_TgIqsgUWb3qLTn-Hk=", "", ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://media.istockphoto.com/id/1359188521/photo/margherita-pizza.webp?b=1&s=170667a&w=0&k=20&c=2MIfeRq5sjiqHyr6IKa5nLeHOgDGwXcJBZcnWUjXVME=","" , ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://media.istockphoto.com/id/1377372234/photo/pizza-with-salami-bell-pepper-tomatoes-and-cheese-pickles-bacon-and-sausages-on-a-light.webp?b=1&s=170667a&w=0&k=20&c=YzA_49p5fH6mh665R9egzdRRYwGpPMoxjnK3Qs6C2Uo=", "", ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://media.istockphoto.com/id/1422644298/photo/hands-picking-pizza-slices.webp?b=1&s=170667a&w=0&k=20&c=3pgCm-7GBZiNVoSo76UcPuwjhrxWoVvv6nJurAitPU4=","" , ScaleTypes.CENTER_CROP))
        imageList.add(SlideModel("https://media.istockphoto.com/id/1374648044/photo/pizza-with-prosciutto-and-basil-served-on-round-wooden-board.webp?b=1&s=170667a&w=0&k=20&c=sWKkGS0zTkhCrm5bT12SFX0Tx36ny0tyBk3fn854Mxo=", "", ScaleTypes.CENTER_CROP))

        binding.imageSlider.setImageList(imageList)

    }
}