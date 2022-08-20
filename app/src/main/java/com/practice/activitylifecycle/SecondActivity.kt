package com.practice.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"

    private lateinit var secondButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
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
        secondButton = findViewById(R.id.second_btn)
        secondButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                val intent = Intent(this@SecondActivity,MainActivity ::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            }
        })

    }
}