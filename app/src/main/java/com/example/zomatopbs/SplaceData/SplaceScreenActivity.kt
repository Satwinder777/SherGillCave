package com.example.zomatopbs.SplaceData

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.example.zomatopbs.Activities.LoginActivity
import com.example.zomatopbs.Fragment.login.NavActivity
import com.example.zomatopbs.MainActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.SplaceData.viewmodel.SplaceViewModel
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf

class SplaceScreenActivity : AppCompatActivity() {
    private lateinit var splaceViewModel: SplaceViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        splaceViewModel = ViewModelProvider(this).get(SplaceViewModel::class.java)


//       val sharephref = SharedPreferencesHelper(this)
//        sharephref.
        Handler().postDelayed({
            if (isUserLogged()==true){
//                val m_data = SharedPreferencesHelper(this).getString(MyConstant.loginkey,MyConstant.defaultValue)

                SharedPreferencesHelper(this).loginType()
                    ?.let { SharedPreferencesHelper(this).getUserDetails()
                        ?.let { it1 -> Allfun.OpenActivity(this,MainActivity::class.java, it1) } }

//                finish()
            }
            else{
                startActivity(Intent(this, NavActivity::class.java))
//                finish()
//                val fragment = 
//                val transaction = fragmentManager.beginTransaction()
//                transaction.replace(R.id.splacescr, fragment)
//                transaction.addToBackStack(null)
//                transaction.commit()
            }
           this.finish()
        }, 2000)
//

    }
    private fun isUserLogged():Boolean{

       return splaceViewModel.isUserLogged(this)

    }
}
