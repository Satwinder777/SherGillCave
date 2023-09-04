package com.example.zomatopbs.Fragment.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.Fragment.navigationfragment.delivery.bottomsheetfragment.SelectlanguageBSheetFragment
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLoginDemoBinding
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseUiException
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit


class LoginFragmentDemo : Fragment(),LoginFaceBookFragment.onclickGmail {

    private lateinit var binding :FragmentLoginDemoBinding
    private lateinit var navController :NavController
    private lateinit var auth: FirebaseAuth

    lateinit var mGoogleSignInClient: GoogleSignInClient

    val emailConfig = AuthUI.IdpConfig.EmailBuilder().build()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginDemoBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
      val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

//        val firebaseapk = FirebaseApp.getInstance()


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().requestProfile()
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
        binding.showLanguages.setOnClickListener {
            SelectlanguageBSheetFragment().show(requireActivity().supportFragmentManager,MyConstant.tag)
        }
        binding.moreSignInOption.setOnClickListener {
            LoginFaceBookFragment(this).show(requireActivity().supportFragmentManager, MyConstant.tag)
        }
        binding.skipButton.setOnClickListener {
            try {

                Allfun.OpenActivity(requireContext(), MainActivity::class.java
                         , userDetail("",""," ",loginVia.LOGINVIA_GUEST))
//                requireActivity().finish()
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
                val number = binding.editNumber.text.toString()
                val fullnumber = "+${binding.ccp.selectedCountryCode}$number"
                phoneRejister(fullnumber)

//                testdata()
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

                try {

                    val response = IdpResponse.fromResultIntent(data)
                    Log.e("exceptionUsingEmail", "onActivityResult: ${response?.providerType}", )

                    if (response?.isSuccessful == true){
                        if (resultCode == Activity.RESULT_OK) {

                            val user = FirebaseAuth.getInstance().currentUser
                            Log.e("blocka", "onActivityResult: block if ", )

                            SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,user?.email.toString())
//                        Log.e("userdata", "onActivityResult: ${user?.email},${response}")
                            Allfun.OpenActivity(requireContext(),MainActivity::class.java
                                , userDetail(user?.displayName.toString(),user?.email.toString(),user?.phoneNumber.toString(),loginVia.LOGINVIA_EMAIL))

                            Toast.makeText(requireContext(), user?.email, Toast.LENGTH_SHORT).show()

//                        requireActivity().finish()

                        } else {
//                        Log.e("userdata", "onActivityResult: ${response}", )

                            Log.e("blocka", "onActivityResult: block else ", )

                            Toast.makeText(requireContext(), "error in onActivityResult", Toast.LENGTH_SHORT).show()
                            Log.e("checkError", "onActivityResult: ${response.error}", )

                        }

                    }
//                    else{
//                        Log.e("userdata", "onActivityResult: ${response?.error}", )
//                    }
                }
                catch (e:Exception){
                    Log.e("exceptionUsingEmail", "onActivityResult: $e", )
                }


            }
            MyConstant.Req_Code->{
                try {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    val account = task.getResult(ApiException::class.java)
                    val credential: AuthCredential = GoogleAuthProvider.getCredential(account?.idToken, null)
                    auth.signInWithCredential(credential).addOnCompleteListener {
                        mytask->
                        if (mytask.isSuccessful){
                            val user = mytask.result.user
                            Log.e("loginViaGmail", "onActivityResult: successfully logged !! ", )
                            Allfun.OpenActivity(requireContext(),MainActivity::class.java,
                                userDetail(user?.displayName.toString(),user?.email.toString(),user?.phoneNumber.toString(),loginVia.LOGINVIA_GMAIL)
                            )


                            requireActivity().finish()
                        }
                        else{
                            Log.e("loginViaGmail", "onActivityResult: failed to load the data ", )

                        }
                    }

//                    Log.e("loginViaGmail", "onActivityResult: ${account.email}",)
//
//                    SharedPreferencesHelper(requireContext()).saveString(MyConstant.key,account.email.toString())





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
    private fun phoneRejister(phoneNumber:String){
          // Replace with the user's phone number
        val phoneAuth = object :PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {

                Toast.makeText(requireContext(), "successfully send otp", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verificationId: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(verificationId, p1)
                Log.e("onCodeSent", "onCodeSent: $verificationId,$p1.", )
                Toast.makeText(requireContext(), "otp send successfully", Toast.LENGTH_SHORT).show()

                val bundle = Bundle()
                bundle.putString("myNumber",binding.editNumber.text.toString())
                bundle.putString("countryCode", binding.ccp.selectedCountryCode)
                bundle.putString("verificationId", verificationId)
                val fragment = LoginFragment()
                fragment.arguments = bundle
                findNavController().navigate(R.id.loginFragment,bundle)

            }

            override fun onVerificationFailed(f: FirebaseException) {

                Toast.makeText(requireContext(), f.message, Toast.LENGTH_SHORT).show()
                Log.e("failedtask", "onVerificationFailed: ${f.message} cause>>${f.cause}", )

            }

        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(120L, TimeUnit.SECONDS)
            .setActivity(requireActivity()) // The activity or fragment where you want to receive callbacks
            .setCallbacks(phoneAuth)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)




    }

    fun testdata(){
        val bundle = Bundle()
        bundle.putString("myNumber",binding.editNumber.text.toString())
        bundle.putString("countryCode", binding.ccp.selectedCountryCode)
        bundle.putString("verificationId", "verificationId")
        val fragment = LoginFragment()
        fragment.arguments = bundle
        findNavController().navigate(R.id.loginFragment,bundle)
    }
}