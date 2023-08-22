package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.OfferModelCls
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SelectlanguageBSheetFragment
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SortBSheetFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.LookingForAdapter
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.LovedRestaurantAdapter
import com.example.zomatopbs.Fragment.navigationfragment.dining.adapter.popularItem1
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentDingingBinding

class DingingFragment : Fragment(), LovedRestaurantAdapter.OnLovedItemClick {
    private lateinit var binding : FragmentDingingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDingingBinding.inflate(layoutInflater)
        val looking_rc = binding.LookingRc
        val loved_rc = binding.mostLovedRestaurantRc
        val loved_adapter = LovedRestaurantAdapter(ininData(rcType.Looking_RC) as MutableList<popularItem1>,this)
        val looking_adapter = LookingForAdapter(
                ininData(rcType.Loved_Restaurant_RC)as MutableList<popularItem1>)
        looking_rc.adapter = looking_adapter
        loved_rc.adapter = loved_adapter
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
        binding.sortSheet.setOnClickListener {
            val sort = SortBSheetFragment()

            sort.show(requireFragmentManager(),"sortDailog")
        }

    }

    private fun ininData(type:rcType):MutableList<*>{
        return when(type){
            rcType.Looking_RC->{
                return mutableListOf(popularItem1(R.drawable.offer1,"Taco Bell"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    popularItem1(R.drawable.offer1,"Taco Bell"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    popularItem1(R.drawable.offer1,"Taco Bell"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    popularItem1(R.drawable.offer1,"Taco Bell"),
                    popularItem1(R.drawable.offer2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer3,"Garam Dharam"),
                    )
            }
            rcType.Loved_Restaurant_RC->{
                return mutableListOf(popularItem1(R.drawable.offer_1,"Taco Bell"),
                    popularItem1(R.drawable.offer_2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer_3,"Garam Dharam"),
                    popularItem1(R.drawable.offer_4,"Taco Bell"),
                    popularItem1(R.drawable.offer_5,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer_6,"Garam Dharam"),
                    popularItem1(R.drawable.offer_2,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer_3,"Garam Dharam"),
                    popularItem1(R.drawable.offer_4,"Taco Bell"),
                    popularItem1(R.drawable.offer_5,"Amingo’s Cafe"),
                    popularItem1(R.drawable.offer_6,"Garam Dharam"),
                )
            }
            else->{
                return mutableListOf("")
            }
        }
    }

    enum class rcType{
        Looking_RC,
        Loved_Restaurant_RC
    }

    override fun onclickloveditem(position: Int) {
        findNavController().navigate(R.id.xeroDegreesFragment)
    }
}