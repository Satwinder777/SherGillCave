package com.example.zomatopbs.Activities

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.zomatopbs.Fragment.login.LoginFaceBookFragment
import com.example.zomatopbs.Fragment.login.LoginFragment
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityLoginBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    lateinit var mGoogleSignInClient: GoogleSignInClient
    val Req_Code: Int = 173
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val firebaseapk =  FirebaseApp.getInstance()



        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        FirebaseApp.initializeApp(this)


        binding.SignInUsingGoogle.setOnClickListener { view: View? ->
            Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show()
            signInGoogle()
        }
        binding.moreSignInOption.setOnClickListener {
            LoginFaceBookFragment().show(supportFragmentManager,MyConstant.tag)
        }
        binding.skipButton.setOnClickListener {
            try {
//                Allfun.OpenActivity(this,MainActivity::class.java)
//                Allfun.navigateScr()
                Allfun.OpenActivity(this,MainActivity::class.java)
                this.finish()
            }
            catch (e:Exception){
                Log.e("satta", "catch block onCreate: ${e.message}", )
            }
            Log.e("satta", "onCreate: clicked!!", )
        }

        binding.vegImage.setOnClickListener {
//            Allfun.OpenActivity(this,MainActivity::class.java )
            Log.e("satta", "onCreate: clicked vegImage!!", )
        }
        binding.editNumber.addTextChangedListener(object : TextWatcher{
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
//                Allfun.OpenFragment(supportFragmentManager,LoginFragment())
                val bundle = Bundle()
                bundle.putString("myNumber",binding.editNumber.text.toString())
                bundle.putString("countryCode",binding.ccp.selectedCountryCode)


                val fragment = LoginFragment()
                fragment.arguments = bundle

                Log.e("satta111", "onCreate: ${binding.editNumber.text}", )
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.login_container, fragment) // R.id.fragment_container is the ID of the container view in your activity's layout
                transaction.addToBackStack(null) // Optional: Add fragment to back stack
                transaction.commit()
            }
            catch (e:Exception){
                Log.e("satta", "onCreate: exception ${e.message}", )
            }
        }

    }

    private fun signInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, Req_Code)


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Req_Code) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val account = task.getResult(ApiException::class.java)
                Log.e("acccount", "onActivityResult: ${account.email}", )
                Allfun.OpenActivity(this,MainActivity::class.java)
                this.finish()



            } catch (e: Exception) {

                Log.e("exception121", "onActivityResult: exception >>${e} ", )
            }

        }
    }

    private fun UpdateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
//                SavedPreference.setEmail(this, account.email.toString())
//                SavedPreference.setUsername(this, account.displayName.toString())

//                Log.e("checkTask", "UpdateUI: $task.", )

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    fun checkNumber(count:Int){
        if (count==10){

        }
    }
}