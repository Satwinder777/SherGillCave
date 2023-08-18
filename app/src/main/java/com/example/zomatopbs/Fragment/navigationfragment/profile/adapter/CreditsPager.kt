package com.example.zomatopbs.Fragment.navigationfragment.profile.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter


//class CreditsPager(fragmentManager: FragmentManager, private val fragmentList: List<Fragment>) : FragmentStateAdapter(fragmentManager) {
//
//    override fun getItemCount(): Int = fragmentList.size
//
//    override fun createFragment(position: Int): Fragment = fragmentList[position]
//}
class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val fragmentList: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}