package com.e.aidmllibrary

import android.content.Context
import android.content.Intent

class InitInstallation(private  val context: Context) {

    fun initInstallation(){
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}