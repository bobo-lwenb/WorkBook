package com.workbook.liuwb.workbook.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.retrofits.RetrofitClient
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

//        RetrofitClient.getInstance(this).getToday()
//        RetrofitClient.getInstance(this).getTheday()
//        RetrofitClient.getInstance(this).searchData()
        RetrofitClient.getInstance(this).searchData1()
//        RetrofitClient.getInstance(this).getGithub()

        val text = retrofit_tv
        text.setText("retrofit")

    }
}