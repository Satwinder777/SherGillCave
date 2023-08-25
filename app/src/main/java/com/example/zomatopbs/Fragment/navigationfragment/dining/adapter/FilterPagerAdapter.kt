package com.example.zomatopbs.Fragment.navigationfragment.dining.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.CostForTwoFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.CuisinesFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.MoreFilterFragment
import com.example.zomatopbs.Fragment.navigationfragment.dining.filterfragment.RatingFragment

class FilterPagerAdapter(private val fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val tabTitles = arrayOf("Tab 1", "Tab 2", "Tab 3","Tab4")

    override fun getCount(): Int {
        return tabTitles.size
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CuisinesFragment()

            1 -> RatingFragment()

            2 -> CostForTwoFragment()

            else ->  MoreFilterFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

}