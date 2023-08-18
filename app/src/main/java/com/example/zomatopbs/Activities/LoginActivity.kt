package com.example.zomatopbs.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.zomatopbs.Fragment.login.LoginFragment
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityLoginBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

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
                Allfun.OpenFragment(supportFragmentManager,LoginFragment())

            }
            catch (e:Exception){
                Log.e("satta", "onCreate: exception ${e.message}", )
            }
        }

    }
    fun checkNumber(count:Int){
        if (count==10){

        }
    }
}