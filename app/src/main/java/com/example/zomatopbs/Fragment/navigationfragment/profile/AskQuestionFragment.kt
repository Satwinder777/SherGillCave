package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.AskQuestionEventAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentAskQuestionBinding


class AskQuestionFragment : Fragment() {

    private lateinit var binding : FragmentAskQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAskQuestionBinding.inflate(layoutInflater)

        val rc = binding.askedquesEventrc
        val adapter = AskQuestionEventAdapter(Mydata())
        rc.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn1.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    fun Mydata():MutableList<String> {
        return mutableListOf("How many ticket can i book through possibility solution",
        "Can i cancem my tickets?","Are my ticckets refundabke?","Where i can see my tickets on Zomato?","Can i book tickets and pay cash at the venue","will i need to carry age-proof at the event?"
        ,"Can i carry food and behavage to the event","will my ticket include seating  at the event","can i transfer my tickets to some one else"," is there a dress code for the event",
            "is there a dress code for the event?","Is there parking at the venue","Is their any age  limit at the event","Do i have to print the tickets"
            )
    }
}