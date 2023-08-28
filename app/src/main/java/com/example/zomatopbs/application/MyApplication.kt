package com.example.zomatopbs.application

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.zomatopbs.objects.FirebaseObject
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

class MyApplication():Application() {
//    class MyApp : Application() {
//        override fun onCreate() {
//            super.onCreate()
//
//            // Initialize FirebaseApp
//            FirebaseApp.initializeApp(this)
//        }
//    }

    override fun onCreate() {
        super.onCreate()
//        val firebaseApp by lazy {
//            FirebaseApp.initializeApp(applicationContext)
//        }

        firebaseAppInit(this)
        try {
            FacebookSdk.sdkInitialize(applicationContext)
            AppEventsLogger.activateApp(this)
        }
        catch (e:Exception)
        {
            Log.e("exception182", "onCreate: ${e.message}", )
        }


    }
    fun firebaseAppInit(context: Context){
        if (FirebaseApp.getApps(context).isEmpty()){
            val options = FirebaseOptions.Builder()
                .setApiKey(FirebaseObject.firebaseKey)
                .setApplicationId(FirebaseObject.firebaseProjectId)
                .setProjectId(FirebaseObject.firebaseProjectId)
                .build()
            FirebaseApp.initializeApp(context, options)


        }

    }
}