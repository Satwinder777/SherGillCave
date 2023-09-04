package com.example.zomatopbs.Fragment.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityPersonalDetailsBinding
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper

class PersonalDetails : Fragment() {
    private lateinit var binding : ActivityPersonalDetailsBinding
    var num = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityPersonalDetailsBinding.inflate(layoutInflater)
        val num = arguments?.getString("myNumber")
        val code = arguments?.getString("countryCode")
        val varId = arguments?.getString("verificationId")


        Log.e("myData", "onCreateView: $num,$code,$varId", )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getDataBtn.setOnClickListener {
            getData()
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun getData(){
        val name = binding.nameEditText.text.trim()
//        val intent = Intent()

        if (name.isNullOrEmpty().not()){
//        intent.putExtra(MyConstant.loginkey,name)
//        requireActivity().setResult(512,intent)
//        requireActivity().onBackPressed()
            var userdtl = userDetail(name.toString(),"",num,loginVia.LOGINVIA_PHONE)
            Allfun.OpenActivity(requireContext(),MainActivity::class.java,userdtl)
            SharedPreferencesHelper(requireContext()).saveUserDetails(userdtl)
            Toast.makeText(requireContext(), "$userdtl", Toast.LENGTH_SHORT).show()

            requireActivity().finish()
        }
        else{
            binding.nameEditText.setError("please Enter your Name",context?.getDrawable(R.drawable.error_icon))
        }
    }
}