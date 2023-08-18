package com.example.zomatopbs.Fragment.navigationfragment.delivery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.SavedAdressAdapter
import com.example.zomatopbs.Fragment.navigationfragment.delivery.adapter.savedAddressData
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentSelectLocationBinding
import com.example.zomatopbs.objects.Allfun

class SelectLocationFragment : Fragment() {
    private lateinit var binding: FragmentSelectLocationBinding
    lateinit var savedAdressAdapter: SavedAdressAdapter
    lateinit var savedrc: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectLocationBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        savedrc = binding.savedrecycler
//        savedrc.layoutManager = LinearLayoutManager(LinearLayoutManager.VERTICAL)
        savedAdressAdapter = SavedAdressAdapter(initData())
        savedrc.adapter = savedAdressAdapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backBtn.setOnClickListener {
            requireParentFragment().requireActivity().onBackPressed()
        }
        binding.currentLocation.setOnClickListener{

//            Allfun.navigateScr(ChooseDeliveryLocationFragment(),requireFragmentManager())
            findNavController().navigateUp()
            findNavController().navigate(R.id.chooseDeliveryLocationFragment)
        }
    }


}
private fun initData():MutableList<savedAddressData>{

    val list = mutableListOf<savedAddressData>(

        savedAddressData("3.0 Km","majitha","the amritsar town majitha"),
        savedAddressData("4.0 Km","Galowali","the city majitha town majitha"),
        savedAddressData("5.0 Km","Colony","the majitha unjab town majitha"),
        savedAddressData("6.0 Km","nawashehar","the nawashehar town majitha"),
        savedAddressData("7.0 Km","ropar","the ropar town majitha"),
        savedAddressData("3.0 Km","majitha","the amritsar town majitha"),
        savedAddressData("4.0 Km","Galowali","the city majitha town majitha"),
        savedAddressData("5.0 Km","Colony","the majitha unjab town majitha"),
        savedAddressData("6.0 Km","nawashehar","the nawashehar town majitha"),
        savedAddressData("7.0 Km","ropar","the ropar town majitha"),
    )

    return list
}