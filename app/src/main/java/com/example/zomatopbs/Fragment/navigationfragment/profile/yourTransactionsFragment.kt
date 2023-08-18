package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.profile.adapter.YourTransactionsAdapter
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentYourTransactionsBinding


class YourTransactionsFragment : Fragment() {
    private lateinit var binding : FragmentYourTransactionsBinding
    lateinit var adapter : YourTransactionsAdapter
    private lateinit var rc : RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentYourTransactionsBinding.inflate(layoutInflater)
        adapter = YourTransactionsAdapter(initdata())

        rc = binding.yourTransactionRc
        rc.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    private fun initdata():MutableList<String>{
        return mutableListOf("Corn Pizza","Paneer Pizza","Onion Pizza","Vegs Pizza")
    }
}