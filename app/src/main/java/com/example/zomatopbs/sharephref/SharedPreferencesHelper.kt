package com.example.zomatopbs.sharephref

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.loginVia
import com.example.zomatopbs.objects.MyConstant
import com.example.zomatopbs.objects.MyConstant.defaultValue
import com.google.gson.Gson
import kotlin.math.log

class SharedPreferencesHelper(val context :Context) {
    private val sharephref :SharedPreferences = context.getSharedPreferences(MyConstant.tag,Context.MODE_PRIVATE)
    val editor  = sharephref.edit()
    val gson = Gson()

    fun saveString(key:String,value:String){
        editor.putString(key, value)

        editor.apply()

    }
    fun getString(key: String,defaultValue:String):String{
        return sharephref.getString(key, defaultValue) ?: defaultValue
    }
    fun loginType():loginVia?{
        var lg:loginVia = loginVia.LOGINVIA_GUEST
        val data = sharephref.getString(MyConstant.loginkey,MyConstant.defaultValue)
       for (i in loginVia.values()){
        if (i.name==data){
               lg = i
            }
           else{
                null
           }
        }
        return lg
    }

    fun saveUserDetails(value:userDetail){
        val strData = gson.toJson(value)
        editor.putString(MyConstant.userlogin_key, strData)
        editor.apply()
    }
    fun getUserDetails(): userDetail? {
        var userData :userDetail ?= null
        try {
            val str = sharephref.getString(MyConstant.userlogin_key, defaultValue) ?: defaultValue
           userData = gson.fromJson(str,userDetail::class.java)
            Log.e("userData", "getUserDetails: $userData", )
        }catch (e:Exception){
            Log.e("userData", "getUserDetails: $e", )

        }

        return userData
    }


    fun clearAllData(){
        editor.clear()
        editor.apply()
    }
}