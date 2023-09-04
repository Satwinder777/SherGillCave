package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.*
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SelectlanguageBSheetFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SortBSheetFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.viewmodel.DeliveryViewModel
import com.example.zomatopbs.Fragment.navigationfragment.profile.LogOutFragment
import com.example.zomatopbs.Fragment.navigationfragment.profile.ProfileFragment
import com.example.zomatopbs.Interfaces.apimodel.PizzaListResponce
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityCountryCodePickerBinding
import com.example.zomatopbs.databinding.FragmentDeliveryBinding
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class DeliveryFragment : Fragment() ,RecommendedItemAdapter.onRecommendedItemClick,OfferItemAdapter.OnOfferItemClick{
    private lateinit var binding: FragmentDeliveryBinding
    lateinit var offerAdapter :OfferItemAdapter
    lateinit var recommendedAdapter :RecommendedItemAdapter
    lateinit var sortingAdapter :SortingRecyclerAdapter
    lateinit var offerrc :RecyclerView
    lateinit var recommendedrc :RecyclerView
    lateinit var sortingrc :RecyclerView
    lateinit var deliveryViewModel: DeliveryViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeliveryBinding.inflate(layoutInflater)
        deliveryViewModel = ViewModelProvider(this).get(DeliveryViewModel::class.java)

        offerrc = binding.offerrc
        val delivertIns = deliveryData.data
        offerAdapter = OfferItemAdapter(delivertIns.initData(deliveryData.OfferModelCls1) as MutableList<OfferModelCls>,this)
        offerrc.adapter = offerAdapter

//tjtdjdt
        recommendedrc = binding.recommrc
        recommendedAdapter = RecommendedItemAdapter(null,this)

        recommendedrc.adapter = recommendedAdapter

        sortingrc = binding.sortrc
        sortingAdapter = SortingRecyclerAdapter(delivertIns.initData(deliveryData.MyString1) as MutableList<String> )
        sortingrc.adapter = sortingAdapter
        isGuest(requireContext())
        initAllData()
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
        binding.menuBtn.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
        binding.languageBtn.setOnClickListener {
           val bottomSheetFragment = SelectlanguageBSheetFragment()
            bottomSheetFragment.show(requireFragmentManager(), bottomSheetFragment.tag)
        }
        binding.sortSheet.setOnClickListener {
            val sort = SortBSheetFragment()

            sort.show(requireFragmentManager(),"sortDailog")
        }
        binding.myOfficialCard.setOnClickListener{

        }
        deliveryViewModel.livePizzaData.observe(requireActivity(), Observer {
            data->
            recommendedAdapter.list = data
            recommendedrc.adapter = recommendedAdapter
            recommendedAdapter.notifyDataSetChanged()
        })

        binding.myEditText.setOnClickListener {
            findNavController().navigate(R.id.searchViewFragment)
        }
    }

    override fun onRecommItemClick() {
        findNavController().navigate(R.id.previewDetailFragment)
    }

    override fun onclickofferitem(position: Int) {
        when(position){
            0->{
                findNavController().navigate(R.id.offersFragment)
//                Allfun.UnderDevelopment(requireContext())
            }
            1->{
                findNavController().navigate(R.id.gourmetFragment)
            }
            2->{
                findNavController().navigate(R.id.gourmetFragment)

            }
            else->{ Allfun.UnderDevelopment(requireContext())}
        }
    }

     fun isGuest(context: Context):Boolean{
       val data = SharedPreferencesHelper(context).getUserDetails()?.loginVia
        return when(data){
            loginVia.LOGINVIA_GUEST->{
                binding.profileIcon.visibility = View.GONE
                binding.menuBtn.visibility = View.VISIBLE

                Log.e("datatype", "isGuest: $data", )
                return true
            }
            else->{
                binding.profileIcon.visibility = View.VISIBLE
                binding.menuBtn.visibility = View.GONE
                Log.e("datatype", "isGuest: $data", )
                return false
            }
        }
    }

private fun initAllData(){
    deliveryViewModel.getPizzaList()
}


}
enum class deliveryData{
    OfferModelCls1,
    MyString1;
//    recommendItemData1;
companion object data{
    fun initData(deliveryData: deliveryData):MutableList<*> {
        return when(deliveryData){
            OfferModelCls1->{
                val list = mutableListOf<OfferModelCls>( OfferModelCls(R.drawable.red_badge_icon,"Offers","Up to 60% OFF"),OfferModelCls(R.drawable.gourmet_icon,"Gourmet","Selections"),OfferModelCls(R.drawable.fruit_bucket_icon,"Healthy","Curated dishes"),OfferModelCls(R.drawable.pizza2,"myPizza","the top Pizza"))
                return list
            }
            MyString1->{
                val list = mutableListOf<String>("Pure veg","fastDelivery","delicious","super",)
                return list
            }
//            recommendItemData1->{
////                val list = mutableListOf<recommendItemData>(recommendItemData(R.drawable.pizza1,R.drawable.pizza2,"title1","title2","text1","text2","offer_1","offer_2")
////                ,recommendItemData(R.drawable.pizza1,R.drawable.pizza2,"title1","title2","text1","text2","offer_1","offer_2"),
////                    recommendItemData(R.drawable.pizza1,R.drawable.pizza2,"title1","title2","text1","text2","offer_1","offer_2"),recommendItemData(R.drawable.pizza1,R.drawable.pizza2,"title1","title2","text1","text2","offer_1","offer_2")
////                        ,recommendItemData(R.drawable.pizza1,R.drawable.pizza2,"title1","title2","text1","text2","offer_1","offer_2")
////                )
//                val list:PizzaListResponce ?= null
//                return list
//            }

        }
    }

}


}
