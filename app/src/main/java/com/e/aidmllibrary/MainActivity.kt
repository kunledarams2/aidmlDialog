package com.e.aidmllibrary

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_installation.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var date: Date? = null
    private var calendar: Calendar? = null
    private var formatter: SimpleDateFormat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get current time
        date = Date()
        calendar = Calendar.getInstance()
        date = calendar!!.time


        openFAB.setOnClickListener { openInstallationDialog() }

    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun openInstallationDialog(){
        val dialog = Dialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_installation, null)

        val currentDate = formatDate(date, "d MMM y" )
        val currentTime = formatDate(date, "H:mm:ss d MMM y")

        view.installation_dec.text = "Library installed on $currentDate"
        view.installation_time.text = "Current time:\n $currentTime"


        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.show()
    }
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    @Throws(ParseException::class)
   private fun formatDate(strDate: Date?, pattern: String?): String? {
        formatter = SimpleDateFormat(pattern)
        return formatter!!.format(strDate!!)
    }
}