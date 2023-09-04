package com.example.zomatopbs.DataClasses

import com.example.zomatopbs.loginVia
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class userDetail(
    val name:String = "",
    val email:String = "",
    val phone:String = "",
    val loginVia: loginVia
) : Parcelable

data class searchitemType(
    var img : Int,
    var title : String,
    var desc : String
)

