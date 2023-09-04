package com.example.zomatopbs.Fragment.navigationfragment.profile

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.zomatopbs.Fragment.login.NavActivity
import com.example.zomatopbs.R
import com.example.zomatopbs.databinding.FragmentLogOutBinding
import com.example.zomatopbs.sharephref.SharedPreferencesHelper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class LogOutFragment(val onLogOuut:OnLogoutUser) : DialogFragment() {

    private lateinit var binding : FragmentLogOutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLogOutBinding.inflate(layoutInflater)

        val cornerRadius = resources.getDimensionPixelSize(R.dimen.dialog_corner_radius) // You can define this in your dimens.xml
        val shapeDrawable = GradientDrawable()
        shapeDrawable.shape = GradientDrawable.RECTANGLE
        shapeDrawable.setColor(Color.WHITE)
        shapeDrawable.cornerRadius = cornerRadius.toFloat()
        this.dialog?.window?.setBackgroundDrawable(shapeDrawable)
       this.isCancelable = false


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelButton.setOnClickListener {
            this.dismiss()
        }
        binding.currentDevice.setOnClickListener {
            this.dismiss()

            SharedPreferencesHelper(requireContext()).clearAllData()

            requireActivity().finish()


            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

         GoogleSignIn.getClient(requireActivity(), gso).signOut()
            val intent = Intent(context, NavActivity::class.java)
            startActivity(intent)

// Sign out the user.


        }
        binding.allDevices.setOnClickListener {
            this.dismiss()
            SharedPreferencesHelper(requireContext()).clearAllData()
//            val fragmentToRemove = requireActivity().finish()

        }

    }

    interface OnLogoutUser{

        fun whenUserLogged(msg:String,context: Context)

    }
}