package com.example.zomatopbs.sharephref

import android.content.Context
import android.content.SharedPreferences
import com.example.zomatopbs.objects.MyConstant

class SharedPreferencesHelper(val context :Context) {
    private val sharephref :SharedPreferences = context.getSharedPreferences(MyConstant.tag,Context.MODE_PRIVATE)
    val editor  = sharephref.edit()

    fun saveString(key:String,value:String){
        editor.putString(key, value)
        editor.apply()

    }
    fun getString(key: String,defaultValue:String):String{
        return sharephref.getString(key, defaultValue) ?: defaultValue
    }

    fun clearAllData(){
        editor.clear()
        editor.apply()
    }
}