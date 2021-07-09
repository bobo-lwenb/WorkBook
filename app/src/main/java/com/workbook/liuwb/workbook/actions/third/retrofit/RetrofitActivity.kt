package com.workbook.liuwb.workbook.actions.third.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.retrofits.RetrofitClient
import com.workbook.liuwb.workbook.databinding.ActivityRetrofitBinding

class RetrofitActivity : AppCompatActivity() {

    private val binding: ActivityRetrofitBinding by lazy {
        ActivityRetrofitBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        RetrofitClient.getInstance(this).getToday()
//        RetrofitClient.getInstance(this).getTheday()
//        RetrofitClient.getInstance(this).searchData()
        RetrofitClient.getInstance(this).searchData1()
//        RetrofitClient.getInstance(this).getGithub()

        binding.retrofitTv.setText("retrofit")
    }
}