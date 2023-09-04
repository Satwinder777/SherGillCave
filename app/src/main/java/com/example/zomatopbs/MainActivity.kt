package com.example.zomatopbs

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.zomatopbs.DataClasses.userDetail
import com.example.zomatopbs.Fragment.login.NavActivity
import com.example.zomatopbs.Fragment.navigationfragment.delivery.DeliveryFragment
import com.example.zomatopbs.Fragment.navigationfragment.profile.LogOutFragment
import com.example.zomatopbs.databinding.ActivityMainBinding
import com.example.zomatopbs.objects.Allfun
import com.example.zomatopbs.objects.MyConstant
import com.google.android.material.bottomnavigation.BottomNavigationView

 class MainActivity : AppCompatActivity(), LogOutFragment.OnLogoutUser {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val data = intent.getParcelableExtra<userDetail>(MyConstant.userlogin_key) as userDetail

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
        bottomNavigationView = binding.bottomNavigation
        NavigationUI.setupWithNavController(bottomNavigationView, navController)




        val startDestinationId = R.id.DeliveryFragment // Replace with your actual start destination ID
        val navGraph = navController.navInflater.inflate(R.navigation.nav_host)
        navGraph.setStartDestination(startDestinationId)
        navController.graph = navGraph



        when(data.loginVia){
            loginVia.LOGINVIA_GUEST ->{ setUpForGuest() }
            loginVia.LOGINVIA_GMAIL->{}
            loginVia.LOGINVIA_FACEBOOK->{
                Toast.makeText(this, "facebook login activated", Toast.LENGTH_SHORT).show()
            }
            loginVia.LOGINVIA_EMAIL->{}
            loginVia.LOGINVIA_PHONE->{}
            else->{
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun setUpForGuest(){
        isUserGuest(true)
       Allfun.UnderDevelopment(this)
    }

    @SuppressLint("ResourceType")
    private fun isUserGuest(guest:Boolean){


        if (guest){
            bottomNavigationView.menu.removeItem(R.id.GroceryFragment)
            bottomNavigationView.menu.removeItem(R.id.MoneyFragment)





        }
        else{


            bottomNavigationView.menu.add(Menu.NONE, R.id.GroceryFragment, Menu.NONE, "Grocery")
                .setIcon(R.drawable.grocery_icon)
            bottomNavigationView.menu.add(Menu.NONE, R.id.MoneyFragment, Menu.NONE, "Money")
                .setIcon(R.drawable.wallet_icon)
        }
    }

     interface LoginType{
         fun isGuest(guest: Boolean)
     }


     @RequiresApi(Build.VERSION_CODES.P)
     override fun whenUserLogged(msg: String,context: Context) {
//        findNavController().navigate(R.id.loginFragmentDemo)

//         requireView().findViewById<BottomNavigationView>(R.id.bottomNavigation).visibility = View.GONE
         Log.e("logoutcall", "whenUserLogged: $msg delivery calls" , )



     }
     fun olUser():LogOutFragment.OnLogoutUser{
         return this
     }
 }

enum class loginVia {
    LOGINVIA_GUEST,
    LOGINVIA_GMAIL,
    LOGINVIA_FACEBOOK,
    LOGINVIA_EMAIL,
    LOGINVIA_PHONE,

}