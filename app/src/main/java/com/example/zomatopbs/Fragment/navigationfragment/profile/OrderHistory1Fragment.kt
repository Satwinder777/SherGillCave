package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app. Fragment
import com.example.zomatopbs.databinding.OrderHistory1Binding

class OrderHistory1Fragment : Fragment() {
    private lateinit var binder: OrderHistory1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = OrderHistory1Binding.inflate(layoutInflater)
        return binder.root
    }
}