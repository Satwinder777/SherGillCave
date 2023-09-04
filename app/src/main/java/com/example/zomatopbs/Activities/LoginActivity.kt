package com.example.zomatopbs.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zomatopbs.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }


    }

//    private fun UpdateUI(account: GoogleSignInAccount) {
//        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
//            if (task.isSuccessful) {
////                SavedPreference.setEmail(this, account.email.toString())
////                SavedPreference.setUsername(this, account.displayName.toString())
//
////                Log.e("checkTask", "UpdateUI: $task.", )
//
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//    }
//
//    fun checkNumber(count:Int){
//        if (count==10){
//
//        }
//    }



