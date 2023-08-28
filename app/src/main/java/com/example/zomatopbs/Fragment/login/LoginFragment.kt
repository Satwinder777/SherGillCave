package com.example.zomatopbs.Fragment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    val vipOtp:String = MyConstant.vipOtp
    var number = ""
    var countryCode = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        number = this.arguments?.getString("myNumber","**987799").toString()
        countryCode = this.arguments?.getString("countryCode","+91").toString()
        binding.myPhoneNumber.setText("+$countryCode $number")
//        Log.e("number", "onCreateView: $number", )


        //init data
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val data = arguments?.getString("myNumber", "09000009009090")
//        Log.e("mydata", "onCreateView: $data", )

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.tvVerify.setOnClickListener {
            if (verifyOtp()==true){
                Allfun.OpenActivity(requireContext(),MainActivity::class.java)
                SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,number)
            }
        }
    }
    private fun verifyOtp():Boolean{
        return when(binding.otpView.otp){
            vipOtp->{
                Allfun.closeFragment(requireFragmentManager(),this)
//                requireParentFragment().requireActivity().finish()
                true
            }
            else->{
                Toast.makeText(requireContext(), "wrong otp", Toast.LENGTH_SHORT).show()
                false
            }
        }

    }
}

