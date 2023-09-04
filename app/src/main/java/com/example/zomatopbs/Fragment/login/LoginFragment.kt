package com.example.zomatopbs.Fragment.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginBinding
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    val vipOtp:String = MyConstant.vipOtp
    var number = ""
    var countryCode = ""
    var otp = MyConstant.vipOtp
    var verificationId = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        number = this.arguments?.getString("myNumber","**987799").toString()
        countryCode = this.arguments?.getString("countryCode","+91").toString()
        verificationId = this.arguments?.getString("verificationId",MyConstant.defaultValue).toString()
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
           otp = binding.otpView.otp.toString()
//            if (==true){
////                SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,number)
//                SharedPreferencesHelper(requireContext()).saveString(MyConstant.loginkey,loginVia.LOGINVIA_PHONE.toString())
//            }

            val bundle = Bundle()
            bundle.putString("myNumber", number)
            bundle.putString("countryCode", countryCode)
            bundle.putString("verificationId", verificationId)
            verifyOtp(otp,bundle)
        }
    }
    var verified : Boolean= true

    private fun verifyOtp(otp: String, bundle:Bundle):Boolean{

        var isCorrectotp : Boolean = false
//       if (otp==MyConstant.vipOtp){
//
//           try {
//              findNavController().navigate(R.id.personalDetails,bundle)
//           }
//           catch (e:Exception){
//               Log.e("erroris", "verifyOtp: ${e.message}", )
//           }
//            isCorrectotp = true
//        }else{
//           Toast.makeText(requireContext(), "false otp", Toast.LENGTH_SHORT).show()
//           isCorrectotp = false
//
//       }


        val credential = PhoneAuthProvider.getCredential(verificationId, otp)
        auth.signInWithCredential(credential).addOnCompleteListener {
                task->
            verified = task.isSuccessful
            if(task.isSuccessful){
                val user = task.result.user

                findNavController().navigate(R.id.personalDetails,bundle)
//                Allfun.OpenActivity(requireContext(), MainActivity::class.java,
//                    userDetail(user?.displayName.toString(),user?.email.toString(),user?.phoneNumber.toString(),loginVia.LOGINVIA_PHONE)
//                )
//                requireActivity().finish()

                Log.e("loginViaPhone", "verifyOtpData: $user", )
                verified = true
            }else{
                Log.e("wrongotp", "verifyOtpData: wrong otp  ${task.exception}", )
                Toast.makeText(requireContext(), "${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
        return verified
return isCorrectotp
    }



}

