package com.example.zomatopbs.SplaceData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.zomatopbs.Activities.LoginActivity
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf

class SplaceScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)




        Handler().postDelayed({
            if (isUserLogged()==true){
                startActivity(Intent(this, MainActivity::class.java))
//                finish()
            }
            else{
                startActivity(Intent(this, LoginActivity::class.java))
//                finish()

            }
           this.finish()
        }, 2000)
//

    }
}
private fun isUserLogged():Boolean{


    return true
}