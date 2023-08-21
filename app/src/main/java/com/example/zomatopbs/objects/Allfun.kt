package com.example.zomatopbs.objects

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.zomatopbs.Fragment.navigationfragment.profile.AboutFragment
import com.example.zomatopbs.R

object Allfun {


    fun OpenActivity(context: Context, targetActivity: Class<*>) {
        val intent = Intent(context, targetActivity)
        context.startActivity(intent)
    }
    fun OpenFragment(manager: FragmentManager,to:Fragment) {
//        val newFragment = AboutFragment()

        val fragmentTransaction = manager.beginTransaction()

// Replace the current fragment with the new fragment
        fragmentTransaction.replace(R.id.nav_host_fragment,to)
        fragmentTransaction.addToBackStack(null) // Add to back stack so user can navigate back
        fragmentTransaction.commit()
    }

     fun closeFragment(manager: FragmentManager, removeFragment:Fragment) {
        manager.beginTransaction()
            .remove(removeFragment)
            .commit()
    }
    fun  navigateScr(newFragment:Fragment,fragmentManager: FragmentManager){

//        val transaction = fragmentManager.beginTransaction()
//        transaction?.replace(R.id.nav_host_fragment, to)
//        transaction?.addToBackStack(null)
//        transaction?.commit()




        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, newFragment)
        transaction.addToBackStack(null)
        transaction.setReorderingAllowed(true)
        transaction.commit()



    }

    fun UnderDevelopment(context: Context){
        Toast.makeText(context, "UnderDevlopment", Toast.LENGTH_SHORT).show()
    }

//    fun goBack(screenType: screenType) {
//        when(screenType){
//            com.example.zomatopbs.objects.screenType.fragment1 ->{
//
//            }
//            com.example.zomatopbs.objects.screenType.activity ->{
//
//            }
//            else->{
//
//            }
//        }
//    }
}
//enum class screenType{
//    fragment1,
//    activity
//}