package com.example.zomatopbs.Activities

import android.app.Activity
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.ActivityCountryCodePickerBinding

class CountryCodePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryCodePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryCodePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)


//val ccp = binding.ccp
//        val a = ccp
        val resultIntent = Intent()
        resultIntent.putExtra("keyName", "someData")
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}