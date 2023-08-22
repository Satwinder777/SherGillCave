package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.*
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentXeroDegreesBinding

class XeroDegreesFragment : Fragment() {


    private lateinit var binding : FragmentXeroDegreesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentXeroDegreesBinding.inflate(layoutInflater)
        val photos_rc = binding.photosRc
        val customer_rc_review = binding.customerReview
        val recommendation_rc = binding.recomendationsRc

        val photos_adapter = PhotosRcAdapter(initdata(xero_rc.photos_rc_) as MutableList<photosRcmodel>)
        val customer_rc_adapter = CustomerReviewAdapter(initdata(xero_rc.customer_rc_review_) as MutableList<popularItem1>,
            initdata(xero_rc.inner_rc_customer_review) as MutableList<Int>)
        val recommendation_adapter = DiningRecommRcAdapter(initdata(xero_rc.recommendation_rc_) as MutableList<DiningRecommodel>)

        photos_rc.adapter = photos_adapter
        recommendation_rc.adapter = recommendation_adapter
        customer_rc_review.adapter = customer_rc_adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mybackbtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }
    private fun initdata(rcType:xero_rc):MutableList<*>{
        return when(rcType){
            xero_rc.photos_rc_->{
                return mutableListOf(
                    photosRcmodel(R.drawable.photo_1,"All","25 Photos"),
                    photosRcmodel(R.drawable.photo_2,"Food","15 Photos"),
                    photosRcmodel(R.drawable.photo_3,"Ambience","45 Photos"),
                    photosRcmodel(R.drawable.photo_1,"All","25 Photos"),
                    photosRcmodel(R.drawable.photo_2,"Food","15 Photos"),
                    photosRcmodel(R.drawable.photo_3,"Ambience","45 Photos"),
                    photosRcmodel(R.drawable.photo_1,"All","25 Photos"),
                    photosRcmodel(R.drawable.photo_2,"Food","15 Photos"),
                    photosRcmodel(R.drawable.photo_3,"Ambience","45 Photos"),
                )
            }
            xero_rc.customer_rc_review_->{
                return mutableListOf(
                    popularItem1(R.drawable.pizza1,"Pizza la Gill"),
                    popularItem1(R.drawable.pizza2,"Pizza la Pneer"),
                    popularItem1(R.drawable.pizza1,"Delicious Onion Pizza"),
                    popularItem1(R.drawable.ding_recomm,"Cake Special"),
                    popularItem1(R.drawable.image3,"South food"),
                    popularItem1(R.drawable.image1,"Pizza la Gill"),
                    popularItem1(R.drawable.image2,"Fried Chawal"),
                )
            }
            xero_rc.recommendation_rc_->{
                return mutableListOf(
                    DiningRecommodel(R.drawable.ding_recomm,"Prankster","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Amritsari","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Pizza la Emo","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Vanela Cake","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Beer","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Vodka","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Black Dog","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Prankster","12.6 kms sector 56"),
                    DiningRecommodel(R.drawable.ding_recomm,"Desi Daruu","12.6 kms sector 56"),
                )
            }
            xero_rc.inner_rc_customer_review ->{
                return mutableListOf(
                    R.drawable.pizza1,
                    R.drawable.pizza2,
                    R.drawable.image3,
                    R.drawable.image2,
                    R.drawable.image1,
                    R.drawable.pizza1,
                    R.drawable.pizza2,
                    R.drawable.ding_recomm,
                )
            }
        }
    }

    enum class xero_rc{

        photos_rc_,
        customer_rc_review_,
        recommendation_rc_,
        inner_rc_customer_review,
    }
}