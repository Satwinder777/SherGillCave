package com.example.zomatopbs.Fragment.navigationfragment.dining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SortBSheetFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.CostForTwoFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.CuisinesFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.RatingFragment
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FilterFragment : BottomSheetDialogFragment() {


    private lateinit var binding :FragmentFilterBinding
    private var isClicked = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val adapter = MyPagerAdapter(childFragmentManager)
        adapter.addFragment(SortBSheetFragment(), "Tab 1")
        adapter.addFragment(CuisinesFragment(), "Tab 2")
        adapter.addFragment(RatingFragment(),"Tab 1")
        adapter.addFragment(CostForTwoFragment(), "Tab 2")
        adapter.addFragment(CuisinesFragment(), "Tab 1")            // MoreFilterFragment

        viewPager.adapter = adapter
        val list = mutableListOf<TextView>(binding.btn,binding.btn1,binding.btn2,binding.btn3,binding.btn4,)


        setStartDraw(list)
        binding.applyBtn.setOnClickListener { this.dismiss() }
//        binding.btn.setOnClickListener {  setFragment(binding.btn) }
//        binding.btn1.setOnClickListener {  setFragment(binding.btn1) }
//        binding.btn2.setOnClickListener {  setFragment(binding.btn2) }
//        binding.btn3.setOnClickListener {  setFragment(binding.btn3) }
//        binding.btn4.setOnClickListener {  setFragment(binding.btn4) }



        // Set the tab layout to vertical flow.
//        tabLayout.setupWithViewPager(viewPager)
    }

    inner class MyPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val fragmentList = ArrayList<Fragment>()
        private val fragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val viewPager = binding.viewPager
//        val tabLayout = binding.tabLayout
//        val adapter=ViewPagerAdapter(requireFragmentManager())
//        adapter.addFragment(BillDetailsXeroFragment(),"First")
//        adapter.addFragment(DingingFragment(),"Second")
//        adapter.addFragment(CallRestaurantFragment(),"Third")
//        viewPager.adapter = adapter
//        tabLayout.setupWithViewPager(viewPager)
//
//    }
//    inner class ViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){
//        private val mFrgmentList = ArrayList<Fragment>()
//        private val mFrgmentTitleList = ArrayList<String>()
//        override fun getCount() = mFrgmentList.size
//        override fun getItem(position: Int) = mFrgmentList[position]
//        override fun getPageTitle(position: Int) = mFrgmentTitleList[position]
//        fun addFragment(fragment:Fragment,title:String){
//            mFrgmentList.add(fragment)
//            mFrgmentTitleList.add(title)
//        }
//    }

    private fun setFragment(view: View){
            when(view){
               binding.btn->{
                   binding.viewPager.currentItem = 0

               }
               binding.btn1->{
                   binding.viewPager.currentItem = 1


               }
               binding.btn2->{
                   binding.viewPager.currentItem = 2

               }
               binding.btn3->{
                   binding.viewPager.currentItem = 3

               }
               binding.btn4->{
                   binding.viewPager.currentItem = 4
               }
            }
    }


    private fun setStartDraw(list: MutableList<TextView>){
        val newDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.vertical_line_bg)

        for ( item in list){

            item.setOnClickListener {
                for (b in list) {
                    b.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
                }
                item.setCompoundDrawablesRelativeWithIntrinsicBounds(newDrawable, null, null, null)

                setFragment(item)
            }

//            else{
//                isClicked = false
//           }
        }
    }
}
