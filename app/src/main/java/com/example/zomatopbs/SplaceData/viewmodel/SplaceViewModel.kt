package com.example.zomatopbs.SplaceData.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper

class SplaceViewModel: ViewModel() {

    fun isUserLogged(context: Context):Boolean{
       val myphref = SharedPreferencesHelper(context)
       val loggedUserDetails = myphref.getUserDetails()


       return if (loggedUserDetails!=null && loggedUserDetails.loginVia!=loginVia.LOGINVIA_GUEST){
           Log.e("loginData", "isUserLogged: $loggedUserDetails ", )
            true
        }
       else{
//            myphref.saveString(myKey,number)
           Log.e("loginData", "isUserLogged: $loggedUserDetails ", )

           false
        }
    }







//    enum class userAuthenticity {
//        userAuthenticated,
//        userNotAuthenticated,
//    }
}