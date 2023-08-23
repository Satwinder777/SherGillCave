package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.Fragment.navigationfragment.delivery.AddItemFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.OfferItem60
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.CompleteAddressFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.MenuFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.*
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentXeroDegreesBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.*

class XeroDegreesFragment : Fragment() {

    private lateinit var binding : FragmentXeroDegreesBinding
    private lateinit var left_to_right: Animation
    private lateinit var slideDownAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        left_to_right = AnimationUtils.loadAnimation(requireContext(), R.anim.left_to_right)
        slideDownAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_down)
    }

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
        val tab_xero = binding.xerotablayout
        // Add tabs to the TabLayout
        tab_xero.addTab(tab_xero.newTab().setText("Offers"))
        tab_xero.addTab(tab_xero.newTab().setText("Photos"))
        tab_xero.addTab(tab_xero.newTab().setText("Reviews"))
        tab_xero.addTab(tab_xero.newTab().setText("Menu"))
        tab_xero.addTab(tab_xero.newTab().setText("About"))
//        tab_xero.addTab(tab_xero.newTab().setText("Recommendations"))

        // Add click listeners to the tabs (optional)
        tab_xero.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab selection
                val offerid = binding.offerid       //0
                val photosid = binding.photosid  //1
                val reviewId = binding.reviewId    //2
                val menuId = binding.menuId     //3
                val aboutId = binding.aboutId       //4
                val recommendtionId = binding.recommendtionId       //5


                val selectedTabPosition = tab?.position ?: 0
                when(selectedTabPosition){
                    0->{
                        hideView(offerid,false)
                        hideView(photosid,false)
                        hideView(reviewId,false)
                        hideView(menuId,false)
                        hideView(aboutId,false)
                        hideView(recommendtionId,false)
                    }
                    1->{
                        hideView(offerid,true)
                        hideView(photosid,false)
                        hideView(reviewId,false)
                        hideView(menuId,false)
                        hideView(aboutId,false)
                        hideView(recommendtionId,false)
                    }
                    2->{
                        hideView(photosid,true)
//                        hideView(photosid,true)
                        hideView(offerid,true)
//                        hideView(photosid,false)
                        hideView(reviewId,false)
                        hideView(menuId,false)
                        hideView(aboutId,false)
                        hideView(recommendtionId,false)


                    }
                    3->{
                        hideView(offerid,true)
                        hideView(photosid,true)
                        hideView(reviewId,true)
//                        hideView(reviewId,true)

//                        hideView(reviewId,false)
                        hideView(menuId,false)
                        hideView(aboutId,false)
                        hideView(recommendtionId,false)

                    }
                    4->{
                        hideView(offerid,true)
                        hideView(photosid,true)
                        hideView(reviewId,true)
                        hideView(menuId,true)

//                        hideView(menuId,true)
//                        hideView(aboutId,true)

                        hideView(aboutId,false)
                        hideView(recommendtionId,false)

                    }
//                    5->{
//                        hideView(offerid,true)
//                        hideView(photosid,true)
//                        hideView(reviewId,true)
//                        hideView(menuId,true)
//                        hideView(aboutId,true)
////                        hideView(recommendtionId,true)
//
//                        hideView(recommendtionId,false)
//
//                    }
                }
                // Perform actions based on the selected tab
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselection
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselection
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mybackbtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.reviewScreen.setOnClickListener {
            findNavController().navigate(R.id.addReviewFragment)
        }
        binding.talkwithai.setOnClickListener {
            findNavController().navigate(R.id.supportMessengerFragment)
        }
        binding.addReviews.setOnClickListener {
            findNavController().navigate(R.id.addReviewFragment)
        }

        binding.seeAllPhotos.setOnClickListener {
            try {

                findNavController().navigate(R.id.photosFragment1)
            }
            catch (e:Exception)
            {
                Log.e("satta1234", "seeAllPhotos: ${e.message}", )
            }
        }
        binding.payBillxero.setOnClickListener {
            findNavController().navigate(R.id.payBillsXerosFragment)
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
    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            // Return the appropriate fragment for each tab
            return when (position) {
                0 -> CompleteAddressFragment()
                1 -> MenuFragment()
                else -> AddItemFragment()
            }
        }

        override fun getCount(): Int {
            // Return the number of tabs
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            // Return the title for each tab
            return when (position) {
                0 -> "Tab 1"
                1 -> "Tab 2"
                else -> "Tab 3"
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun hideView(view: View, boolean: Boolean){
        try {
            if (boolean){
                GlobalScope.launch(Dispatchers.Main) {
                    view.startAnimation(left_to_right)
                    delay(600)
                    view.visibility = View.GONE
                }
            }
            else{
                view.visibility = View.VISIBLE
//                view.startAnimation(slideDownAnimation)


            }
        }
        catch (e:Exception){
            Log.e("satta", "exception is==> ${e.message}", )
        }

    }
}