package com.example.zomatopbs.Fragment.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginFaceBookBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth


class LoginFaceBookFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentLoginFaceBookBinding
    val callbackManager = CallbackManager.Factory.create()
    val FACEBOOK_CODE = 188
    private lateinit var firebaseAuth :FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding  = FragmentLoginFaceBookBinding.inflate(layoutInflater)
        dialog?.setCancelable(false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.facebook.setOnClickListener {
//
//
////            dialog?.dismiss()
//        }



        binding.facebookBtn.setPermissions("email", "public_profile")
        binding.facebookBtn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {


            override fun onSuccess(result: LoginResult) {
                firebaseAuth = FirebaseAuth.getInstance()
                // Successful Facebook login
                val credential = FacebookAuthProvider.getCredential(result.accessToken.token)
                firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
//                            val intent = Intent(this@Google_Facebook_login,MainActivity1::class.java)
//                            startActivity(intent)
                            val user = firebaseAuth.currentUser
                            Log.e("checkUser", "onSuccess: ${user?.email}", )
                            // Do something with the user object
                        } else {
                            // Firebase authentication failed
                            Toast.makeText(requireContext(), "Authentication failed.   ",
                                Toast.LENGTH_SHORT).show()
                            Log.e("tag1234", "onSuccess: ${task.exception?.message}", )
                        }
                    }
            }

            override fun onCancel() {
                // User cancelled Facebook login
                Toast.makeText(requireContext(), "Login cancelled.",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException) {
                // Facebook login error
                Toast.makeText(requireContext(), "Login error: ${error.message}",
                    Toast.LENGTH_SHORT).show()
            }
        })

//        binding.email.setOnClickListener {
//
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)

    }
}