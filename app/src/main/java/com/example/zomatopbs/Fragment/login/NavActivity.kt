package com.example.zomatopbs.Fragment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityLoginBinding
import com.example.zomatopbs.databinding.ActivityNavBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class NavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        FirebaseApp.initializeApp(this)



    }



//    override fun gmailClicked(data: String) {
//        val fragment = EmailFragment()
//        Log.e("checked12", "gmailClicked:msg>>>>$data task called",)
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(
//            R.id.login_container,
//            fragment
//        ) // R.id.fragment_container is the ID of the container view in your activity's layout
//        transaction.addToBackStack(null) // Optional: Add fragment to back stack
//        transaction.commit()
//    }
}