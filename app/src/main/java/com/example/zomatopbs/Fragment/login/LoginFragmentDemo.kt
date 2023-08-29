package com.example.zomatopbs.Fragment.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginDemoBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class LoginFragmentDemo : Fragment(),LoginFaceBookFragment.onclickGmail {

    private lateinit var binding :FragmentLoginDemoBinding
    private lateinit var navController :NavController


    lateinit var mGoogleSignInClient: GoogleSignInClient

    private lateinit var firebaseAuth: FirebaseAuth
    val emailConfig = AuthUI.IdpConfig.EmailBuilder().build()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginDemoBinding.inflate(layoutInflater)
      val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        val firebaseapk = FirebaseApp.getInstance()


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()


        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val list = listOf( AuthUI.IdpConfig.EmailBuilder().build(),)
        binding.SignInUsingGoogle.setOnClickListener { view: View? ->
            Toast.makeText(requireContext(), "Logging In", Toast.LENGTH_SHORT).show()
            signInGoogle()
        }
        binding.moreSignInOption.setOnClickListener {
            LoginFaceBookFragment(this).show(requireActivity().supportFragmentManager, MyConstant.tag)
        }
        binding.skipButton.setOnClickListener {
            try {

//                Allfun.OpenActivity(requireContext(), MainActivity::class.java)
//                this.finish()
                val intent = Intent(requireContext(),MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Log.e("satta", "catch block onCreate: ${e.message}",)
            }
            Log.e("satta", "onCreate: clicked!!",)
        }

        binding.vegImage.setOnClickListener {
//            Allfun.OpenActivity(this,MainActivity::class.java )
            Log.e("satta", "onCreate: clicked vegImage!!",)
        }
        binding.editNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.length > 10) {
                        val trimmedText = it.substring(0, 10)
                        s.replace(0, s.length, trimmedText)
                    }
                }
            }

        })

        binding.verifyOtp.setOnClickListener {
            try {

                val bundle = Bundle()
                bundle.putString("myNumber", binding.editNumber.text.toString())
                bundle.putString("countryCode", binding.ccp.selectedCountryCode)

                val fragment = LoginFragment()
                fragment.arguments = bundle
                findNavController().navigate(R.id.loginFragment,bundle)

//                Log.e("satta111", "onCreate: ${binding.editNumber.text}",)
//                val transaction = requireActivity().supportFragmentManager.beginTransaction()
//                transaction.replace(
//                    R.id.login_container,
//                    fragment
//                ) // R.id.fragment_container is the ID of the container view in your activity's layout
//                transaction.addToBackStack(null) // Optional: Add fragment to back stack
//                transaction.commit()
            } catch (e: Exception) {
                Log.e("satta", "onCreate: exception ${e.message}",)
            }
        }
    }

    override fun gmailClicked(data: String) {
        showEmailBuilder()
    }
    private fun signInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, MyConstant.Req_Code)


    }

    @SuppressLint("RestrictedApi")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            MyConstant.Email_builder->{

                    val response = IdpResponse.fromResultIntent(data)
                if (response?.isSuccessful == true){
                    if (resultCode == Activity.RESULT_OK) {

                        val user = FirebaseAuth.getInstance().currentUser

                        SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,user?.email.toString())
                        Log.e("userdata", "onActivityResult: ${user?.email},${response}", )
                        val intent = Intent(requireContext(),MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(requireContext(), user?.email, Toast.LENGTH_SHORT).show()
                    } else {
                        Log.e("userdata", "onActivityResult: ${response}", )

                        Toast.makeText(requireContext(), "error in onActivityResult", Toast.LENGTH_SHORT).show()

                    }

                }
                else{
                    Log.e("userdata", "onActivityResult: ${response?.error}", )
                }

            }
            MyConstant.Req_Code->{
                try {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    val account = task.getResult(ApiException::class.java)
                    Log.e("acccount", "onActivityResult: ${account.email}",)

                    SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,account.email.toString())

                    val intent = Intent(requireContext(),MainActivity::class.java)
                    startActivity(intent)


                } catch (e: Exception) {

                    Log.e("exception121", "onActivityResult: exception >>${e} ",)
                }
            }
        }


    }
    private fun showEmailBuilder(){
        val authUI = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(listOf(emailConfig)) // Add other sign-in providers as needed
            .build()

        startActivityForResult(authUI, MyConstant.Email_builder)// Use an appropriate request code (RC_SIGN_IN) for onActivityResult

    }
}