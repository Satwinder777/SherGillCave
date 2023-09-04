package com.example.zomatopbs.Fragment.login


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginFaceBookBinding
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class LoginFaceBookFragment(val onclickmail : onclickGmail) : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentLoginFaceBookBinding
    private lateinit var callbackManager : CallbackManager
    private lateinit var auth: FirebaseAuth

//    val callbackManager = CallbackManager.Factory.create()
    val FACEBOOK_CODE = 188

    private lateinit var firebaseAuth :FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentLoginFaceBookBinding.inflate(layoutInflater)
//        dialog?.setCancelable(false)
        auth = FirebaseAuth.getInstance()

        return binding.root

    }


    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callbackManager = CallbackManager.Factory.create()

//        binding.facebookBtn.setPermissions("email", "public_profile")
//        binding.facebookBtn.setReadPermissions(Arrays.asList("email"))



        binding.email.setOnClickListener {
            val my_fragment = EmailFragment()

            try {
                dialog?.dismiss()
                    onclickmail.gmailClicked("satta")
//                findNavController().navigate(R.id.emailFragment)


            }catch (e:Exception){
                Log.e("exceptionmy", "onViewCreated: ${e.message}", )
            }

        }
        binding.facebook.setOnClickListener {
            performFacebookLogin()

        }
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {

        super.onActivityResult(requestCode, resultCode, data)
       callbackManager.onActivityResult(requestCode, resultCode, data)

    }
    fun performFacebookLogin() {
        // For example, you can trigger the login like this:
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
        // Replace 'this' with your activity or fragment context

        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                // Handle successful login here
                val accessToken = result.accessToken

                val credential = FacebookAuthProvider.getCredential(accessToken.token)
                auth.signInWithCredential(credential).addOnCompleteListener {
                    task->

                    if (task.isSuccessful){
                        val user = task.result.user
//                        SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,user?.email.toString())

                        Allfun.OpenActivity(requireContext(),MainActivity::class.java
                        , userDetail(user?.displayName.toString(),user?.email.toString(),user?.phoneNumber.toString(),loginVia.LOGINVIA_GMAIL)
                        )

                        Toast.makeText(requireContext(), "${user?.email}", Toast.LENGTH_SHORT).show()
                        SharedPreferencesHelper(requireContext()).saveString(MyConstant.loginkey,loginVia.LOGINVIA_FACEBOOK.toString())
                        requireActivity().finish()
                    }else{
                        Toast.makeText(requireContext(), task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                    dialog?.dismiss()
                }
                // You can access user information via GraphRequest here if needed.
                Toast.makeText(requireContext(), "onsuccess", Toast.LENGTH_SHORT).show()
                Log.d("datatest12", "Facebook token: " + result!!.accessToken.token)
            }

            override fun onCancel() {
                // Handle login cancellation here
                Toast.makeText(requireContext(), "oncancel", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()

            }

            override fun onError(e: FacebookException) {
                Toast.makeText(requireContext(), "onexception>>$e", Toast.LENGTH_SHORT).show()

                // Handle login error here
                dialog?.dismiss()

            }
        })
    }
//    fun Fragment.openFragment(fragment: Fragment, containerId: Int) {
//
//        val transaction = childFragmentManager.beginTransaction()
//        transaction.replace(containerId, fragment) // R.id.fragment_container is the ID of the container view in your activity's layout
//        transaction.addToBackStack(null) // Optional: Add fragment to back stack
//        transaction.commit()
////        val transaction = fragmentManager.beginTransaction()
////        transaction.replace(containerId, fragment)
////        transaction.addToBackStack(null)
////        transaction.commit()
//
//    }
    fun Activity.openFragment(fragment: Fragment, containerId: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    interface onclickGmail{
        fun gmailClicked(data:String)
    }
}