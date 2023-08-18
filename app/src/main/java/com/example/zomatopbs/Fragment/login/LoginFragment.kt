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


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    val vipOtp:String = MyConstant.vipOtp
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)

        //init data
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvVerify.setOnClickListener {
            if (verifyOtp()==true){
                Allfun.OpenActivity(requireContext(),MainActivity::class.java)
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

