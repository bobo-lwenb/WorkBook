package com.workbook.liuwb.workbook.fragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R

class LifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.e("activity: ", "onCreate")

        val fragment = LifeCycleFragment()
        supportFragmentManager.beginTransaction().add(R.id.lifecycle, fragment).commit()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("activity: ", "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("activity: ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("activity: ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("activity: ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("activity: ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("activity: ", "onDestroy")
    }
}