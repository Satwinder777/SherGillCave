package com.example.zomatopbs.SplaceData.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.sharephref.SharedPreferencesHelper

class SplaceViewModel: ViewModel() {

    fun isUserLogged(context: Context):Boolean{
       val myphref = SharedPreferencesHelper(context)
        val myKey = MyConstant.key
       val loggedUserDetails = myphref.getString(myKey,"not user found")

//        return when(userAuthenticity.userAuthenticated){
//             userAuthenticity.userAuthenticated->{}
//            userAuthenticity.userNotAuthenticated->{}
//        }
       return if (loggedUserDetails!=null && loggedUserDetails!="not user found"){
            true
        }
       else{
//            myphref.saveString(myKey,number)
           false
        }
    }







//    enum class userAuthenticity {
//        userAuthenticated,
//        userNotAuthenticated,
//    }
}