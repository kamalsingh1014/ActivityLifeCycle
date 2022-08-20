package com.practice.activitylifecycle

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupWindow

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var mainButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manageAndSwitchActivity()
        Log.d(TAG,"onCreate() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart() called")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
    private fun manageAndSwitchActivity(){
        mainButton = findViewById(R.id.main_btn)
        mainButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
//                val intent = Intent(this@MainActivity,SecondActivity ::class.java)
//                startActivity(intent)
                showPopUp()

            }
        })
    }
    fun showPopUp(){
        val popupView: View =
            LayoutInflater.from(this)
                .inflate(R.layout.popup, null)
        //For setting the popup at specific location
        popupView.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        val popupWindow = PopupWindow(
            popupView,
            WindowManager.LayoutParams.MATCH_PARENT ,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        popupWindow.isFocusable = true
        popupWindow.isOutsideTouchable = true
        popupWindow.elevation =
            this.resources.getDimension(R.dimen.mg_10)
        val values = IntArray(2)
        mainButton.getLocationInWindow(values)
        val positionOfIcon = values[1]
        val displayMetrics =
            this.resources.displayMetrics                                            //Get the height of 8/10th of the height of the screen
        val height = displayMetrics.heightPixels * 8 / 10
//            val height = displayMetrics.heightPixels * 9 / 10

        //If the position of menu icon is in the bottom 2/3rd part of the screen then we provide menu height as offset  but in negative as we want to open our menu to the top
            popupWindow.showAsDropDown(
                mainButton,
                100,
                -(popupView.measuredHeight + mainButton.height - 150),
                Gravity.START
            )

    }
}