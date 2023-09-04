package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentSearchViewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class SearchViewFragment : Fragment() {

    private lateinit var binding : FragmentSearchViewBinding
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchViewBinding.inflate(layoutInflater)

//         val searchview =  binding.mySearchFood
        tabLayout = binding.myTab
        viewPager = binding.myViewPager

        var myFragmentList = mutableListOf<Fragment>(FoodDetailsFragment(),PreviewDetailFragment())
        var adapter = MyPagerAdapter12(myFragmentList)
//        val tab1 = tabLayout.getTabAt(0)
//        tab1?.text = "Tab 1 Text"
//
//        val tab2 = tabLayout.getTabAt(1)
//        tab2?.text = "Tab 2 Text"
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

     inner class MyPagerAdapter12(private val fragmentList: List<Fragment>) : FragmentPagerAdapter(requireActivity().supportFragmentManager) {

         override fun getCount(): Int {
            return fragmentList.size
         }

         override fun getItem(position: Int): Fragment {
             return fragmentList[position]
         }

         override fun getPageTitle(position: Int): CharSequence? {
//             return super.getPageTitle(position)

            return when(position){
                 0->{
                     "Delivery"
                 }
                 1->{
                     "Dinging"
                 }
                 else->{
                     "Else"
                 }
             }
         }
     }

}