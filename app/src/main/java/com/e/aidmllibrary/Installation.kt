package com.e.aidmllibrary

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.dialog_installation.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Installation(private  val context: Context) {

    private var date: Date? = null
    private var calendar: Calendar? = null
    private var formatter: SimpleDateFormat? = null

    private var floatingActionButton: FloatingActionButton? = null

    fun initInstallation(linearLayout: ConstraintLayout) {
        date = Date()
        calendar = Calendar.getInstance()
        date = calendar!!.time

        setFABView(linearLayout)
    }

    @SuppressLint("ResourceType")
    private fun setFABView(constraintLayout: ConstraintLayout) {

        /** clone parent constraintLayout**/
        val set = ConstraintSet()
        set.clone(constraintLayout)

        /**set up floatActionButton**/
        floatingActionButton = FloatingActionButton(context)
        floatingActionButton!!.id = 1002

        floatingActionButton!!.setMaxImageSize(40)
        floatingActionButton!!.setImageResource(R.drawable.ic_outline_play_arrow_24)
        floatingActionButton!!.setRippleColor(ColorStateList.valueOf(Color.WHITE))
        floatingActionButton!!.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#5597FB"))

        floatingActionButton!!.setOnClickListener { openInstallationDialog() }
        constraintLayout.addView(floatingActionButton)

        /**connect the floatingActionButton to constrainLayout**/
        set.connect(floatingActionButton!!.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 40)
        set.connect(floatingActionButton!!.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 40)
//       set.connect(floatingActionButton!!.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,20)
        set.constrainHeight(floatingActionButton!!.id, 90)
        set.constrainWidth(floatingActionButton!!.id, 90)
        set.applyTo(constraintLayout)


    }


    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun openInstallationDialog() {
        val dialog = Dialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_installation, null)

        val currentDate = formatDate(date, "d MMM y")
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