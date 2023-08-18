package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.ViewPagerAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentZomatoCreditsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ZomatoCreditsFragment : Fragment() {

    private lateinit var binding : FragmentZomatoCreditsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentZomatoCreditsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = binding.viewPager
        val tabLayout : TabLayout = binding.tabLayout
          // Replace with your fragments
        val adapter = ViewPagerAdapter(requireActivity(), fragmentlist())
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0->{
                    tab.text = "Transcation"
                }
                1->{
                    tab.text = "Additions"
                }
                2->{
                    tab.text ="Deductions"
                }
            }
        }.attach()
    }

    private fun fragmentlist():MutableList<Fragment>{

        return mutableListOf(FeedBackFragment(),AboutFragment(),LikesFragment())
    }
}
